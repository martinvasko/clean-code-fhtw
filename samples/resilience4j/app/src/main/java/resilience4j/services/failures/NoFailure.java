package resilience4j.services.failures;

public class NoFailure implements PotentialFailure {
    @Override
    public void occur() {
    }
}
