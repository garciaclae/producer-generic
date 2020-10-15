package mx.gob.nayatit.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.gob.nayatit.model.Producer;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Serializer class for objects of type Producer
 * @author Ricardo Lopez
 */
public class ProducerSerializer implements Serializer<Producer> {

    private static Logger logger = LoggerFactory.getLogger(ProducerSerializer.class);

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Producer producer) {
        return new byte[0];
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Producer data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }

        return new byte[0];
    }

    @Override
    public void close() {

    }
}
