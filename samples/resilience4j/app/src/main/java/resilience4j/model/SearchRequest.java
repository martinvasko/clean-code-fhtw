package resilience4j.model;

public class SearchRequest {
    String from;
    String to;
    String trainDate;

    public SearchRequest(String from, String to, String trainDate) {
        this.from = from;
        this.to = to;
        this.trainDate = trainDate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTrainDate() {
        return trainDate;
    }
}
