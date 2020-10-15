package mx.gob.nayatit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.gob.nayatit.dtos.OutputProcess;
import mx.gob.nayatit.dtos.rest.Response;
import mx.gob.nayatit.exceptions.ProducerBusinessException;
import mx.gob.nayatit.model.Producer;
import mx.gob.nayatit.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class controller charge to process the Producer objects.
 *
 * @author Ricardo Lopez
 * @version 1.0.0
 */
@RestController
@RequestMapping("/producer")
@Api(value = "ProducerController", produces = "application/json", consumes = "application/json")
public class ProducerController {

    /**
     * Logger for print information.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    /**
     * Producer Service instance.
     */
    private ProducerService<Producer> producerService;

    /**
     * Constructor of class.
     * @param producerService   The instance of ProducerService.
     */
    public ProducerController(ProducerService<Producer> producerService) {
        this.producerService = producerService;
    }

    /**
     * This method save the information of Producer in a kafka topic.
     * @param producer  The Producer to persist.
     * @return  A ResponseEntity with the information.
     */
    @ApiOperation(value = "Se guarda la informacion del Producer", response = OutputProcess.class)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Persistido"),
                            @ApiResponse(code = 500, message = "Internal Server Error") })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<OutputProcess> save(@RequestBody Producer producer) throws ProducerBusinessException {
        LOGGER.info("ProducerController -  save - params {}", producer);
        String id = producerService.save(producer);
        return Response.ofCreate("OK", id);
    }

}
