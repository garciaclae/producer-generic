package mx.gob.nayatit.dtos;

import java.util.List;

/**
 * Contain the status of response.
 * @author Ricardo Lopez
 */
public class Status {
    private String message;
    private List<String> errors;

    public static Status of(String message, List<String> errors) {
        return new Status(message, errors);
    }

    private Status(String message, List<String> errors){
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

}
