package mx.gob.nayatit.service;

import mx.gob.nayatit.exceptions.ProducerBusinessException;

/**
 * Class to define a service for producer
 * @author Ricardo Lopez
 * @param <T>   The type of data
 */
public interface ProducerService<T> {

    /**
     * Save a data of producer in a Kafka topic.
     * @param producer  The object to persists
     * @return  A String with result
     * @throws ProducerBusinessException    When can not save
     */
    String save(T producer) throws ProducerBusinessException;
}
