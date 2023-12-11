package resilience4j.model;

public class BookingRequest {
    String requestId;
    Train train;
    int seatCount;
    String seatClass;

    public BookingRequest(String requestId, Train train, int seatCount, String seatClass) {
        this.requestId = requestId;
        this.train = train;
        this.seatCount = seatCount;
        this.seatClass = seatClass;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
}
