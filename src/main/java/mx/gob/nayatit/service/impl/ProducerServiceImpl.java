package mx.gob.nayatit.service.impl;

import mx.gob.nayatit.model.Producer;
import mx.gob.nayatit.producer.ProducerKafka;
import mx.gob.nayatit.service.ProducerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService<Producer> {

    private ProducerKafka producerKafka;

    public ProducerServiceImpl(ProducerKafka producerKafka) {
        this.producerKafka = producerKafka;
    }

    @Override
    public String save(Producer producer) {
        producerKafka.send(producer);
        return UUID.randomUUID().toString();
    }

}
