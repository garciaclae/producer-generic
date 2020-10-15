package mx.gob.nayatit.dtos;

/**
 * This class define the output for rest controllers.
 * @param <T>   The type of data response.
 */
public class OutputProcess<T> {
    private Status status;
    private T data;

    public OutputProcess(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public Status getState() {
        return status;
    }

    public void setState(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
