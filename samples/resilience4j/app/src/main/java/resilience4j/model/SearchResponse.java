package resilience4j.model;

import java.util.List;

public class SearchResponse {
    String errorCode;
    List<Train> trains;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", trains=" + trains +
                '}';
    }
}
