package mx.gob.nayatit.producer;

import mx.gob.nayatit.model.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Class handles the send of data to kafka.
 * @author Ricardo Lopez
 */
@Service
public class ProducerKafka {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerKafka.class);

    private KafkaTemplate<String, Producer> kafkaTemplate;

    private String producerTopic;

    public ProducerKafka(KafkaTemplate<String, Producer> kafkaTemplate,
                         @Value("${kafka.topic.producerTopic}") String producerTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.producerTopic = producerTopic;
    }

    public boolean send(Producer producer){
        Message<Producer> message = MessageBuilder.withPayload(producer)
                .setHeader(KafkaHeaders.TOPIC, producerTopic)
                .build();
        kafkaTemplate.send(message);
        kafkaTemplate.flush();
        LOGGER.info("Message delivered");
        return true;
    }
}
