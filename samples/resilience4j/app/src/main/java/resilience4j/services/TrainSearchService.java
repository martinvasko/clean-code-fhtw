package resilience4j.services;

import resilience4j.model.Train;
import resilience4j.model.SearchRequest;
import resilience4j.model.SearchResponse;
import resilience4j.services.failures.NoFailure;
import resilience4j.services.failures.PotentialFailure;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class TrainSearchService {
    PotentialFailure potentialFailure = new NoFailure();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss SSS");

    public List<Train> searchTrains(SearchRequest request) {
        System.out.println("Searching for trains; current time = " + LocalDateTime.now().format(formatter));
        potentialFailure.occur();

        List<Train> trains = Arrays.asList(
                new Train("XY 765", request.getTrainDate(), request.getFrom(), request.getTo()),
                new Train("XY 781", request.getTrainDate(), request.getFrom(), request.getTo()),
                new Train("XY 732", request.getTrainDate(), request.getFrom(), request.getTo()),
                new Train("XY 746", request.getTrainDate(), request.getFrom(), request.getTo())
        );
        System.out.println("Train search successful");
        return trains;
    }

    public List<Train> searchTrainsThrowingException(SearchRequest request) throws Exception {
        System.out.println("Searching for trains; current time = " + LocalDateTime.now().format(formatter));
        throw new Exception("Exception when searching for trains");
    }

    public void setPotentialFailure(PotentialFailure potentialFailure) {
        this.potentialFailure = potentialFailure;
    }

    public SearchResponse httpSearchTrains(SearchRequest request) throws IOException {
        System.out.println("Searching for trains; current time = " + LocalDateTime.now().format(formatter));
        potentialFailure.occur();

        String date = request.getTrainDate();
        String from = request.getFrom();
        String to = request.getTo();
        if (request.getTrainDate().equals("07/25/2020")) { // Simulating an error scenario
            System.out.println("Train data initialization in progress, cannot search at this time");
            SearchResponse response = new SearchResponse();
            response.setErrorCode("FS-167");
            response.setTrains(Collections.emptyList());
            return response;
        }

        List<Train> trains = Arrays.asList(
                new Train("XY 765", date, from, to),
                new Train("XY 781", date, from, to),
                new Train("XY 732", date, from, to),
                new Train("XY 746", date, from, to)
        );
        System.out.println("Train search successful");
        SearchResponse response = new SearchResponse();
        response.setTrains(trains);
        return response;
    }
}
