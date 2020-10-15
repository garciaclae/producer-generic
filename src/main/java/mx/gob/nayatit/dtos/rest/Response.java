package mx.gob.nayatit.dtos.rest;

import mx.gob.nayatit.dtos.OutputProcess;
import mx.gob.nayatit.dtos.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

/**
 * Create the response with a structure define in OutputProcess class.
 * @author Ricardo Lopez
 */
public class Response {

    private Response() {
    }

    public static <T> ResponseEntity<OutputProcess> ofSuccess(String message, T data){
        return new ResponseEntity<>(new OutputProcess<>(Status.of(message, Arrays.asList()), data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<OutputProcess> ofCreate(String message, T data){
        return new ResponseEntity<>(new OutputProcess<>(Status.of(message, Arrays.asList()), data), HttpStatus.CREATED);
    }
}
