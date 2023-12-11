package resilience4j;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import resilience4j.services.TrainSearchService;
import resilience4j.services.failures.FailNTimes;
import resilience4j.model.SearchRequest;
import resilience4j.model.SearchResponse;
import resilience4j.model.Train;

public class RetrySetup {

    public void initDefault() {
        RetryConfig config = RetryConfig.ofDefaults();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("trainSearchService", config);
        
        TrainSearchService trainSearchService = new TrainSearchService();
        SearchRequest searchRequest = new SearchRequest("Wien", "Budapest", "2023-01-01");
        Supplier<List<Train>> trainSearchSupplier = () -> trainSearchService.searchTrains(searchRequest);

        Supplier<List<Train>> retryingTrainSearch = Retry.decorateSupplier(retry, trainSearchSupplier);
    
        System.out.println(retryingTrainSearch.get());
    }

    public void initShaky() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(4)
                .waitDuration(Duration.of(2, SECONDS))
                .build();

        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("trainSearchService", config);
        
        TrainSearchService trainSearchService = new TrainSearchService();
        trainSearchService.setPotentialFailure(new FailNTimes(3));
        SearchRequest searchRequest = new SearchRequest("Wien", "Budapest", "2023-01-01");
        Supplier<List<Train>> trainSearchSupplier = () -> trainSearchService.searchTrains(searchRequest);

        Supplier<List<Train>> retryingTrainSearch = Retry.decorateSupplier(retry, trainSearchSupplier);
    
        System.out.println(retryingTrainSearch.get());
    }

    public void initCustom(int failures, int maxAttempts) {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(maxAttempts)
                .waitDuration(Duration.of(2, SECONDS))
                .build();

        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("trainSearchService", config);
        
        TrainSearchService trainSearchService = new TrainSearchService();
        trainSearchService.setPotentialFailure(new FailNTimes(failures));
        SearchRequest searchRequest = new SearchRequest("Wien", "Budapest", "2023-01-01");
        Supplier<List<Train>> trainSearchSupplier = () -> trainSearchService.searchTrains(searchRequest);

        Supplier<List<Train>> retryingTrainSearch = Retry.decorateSupplier(retry, trainSearchSupplier);
    
        System.out.println(retryingTrainSearch.get());
    }
}
