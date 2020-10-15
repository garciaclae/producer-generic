package mx.gob.nayatit.exceptions.handler;

import mx.gob.nayatit.dtos.OutputProcess;
import mx.gob.nayatit.dtos.Status;
import mx.gob.nayatit.exceptions.ProducerBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

/**
 * This class handles all he kind of exception in the application.
 * @author Ricardo Lopez
 */
@ControllerAdvice
public class ProducerResposeEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProducerBusinessException.class})
    protected ResponseEntity<OutputProcess> businessError(ProducerBusinessException e, WebRequest wr){
        return new ResponseEntity<>(new OutputProcess<>(Status.of("The request can not processed", Arrays.asList(e.getMessage())), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    protected ResponseEntity<OutputProcess> generalError(Exception e){
        return new ResponseEntity<>(new OutputProcess<>(Status.of("The request can not processed", Arrays.asList(e.getMessage())), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
