package resilience4j.model;

public class Train {
    String trainNumber;
    String trainDate;
    String from;
    String to;

    public Train() {
    }

    public Train(String trainNumber, String trainDate, String from, String to) {
        this.trainNumber = trainNumber;
        this.trainDate = trainDate;
        this.from = from;
        this.to = to;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Train {" +
                "trainNumber='" + trainNumber + '\'' +
                ", trainDate='" + trainDate + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
