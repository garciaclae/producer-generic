package mx.gob.nayatit.exceptions;

/**
 * This exception wrap the errors for business logic.
 * @author Ricardo Lopez
 */
public class ProducerBusinessException extends Exception {
    public ProducerBusinessException(String message) {
        super(message);
    }

    public ProducerBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
