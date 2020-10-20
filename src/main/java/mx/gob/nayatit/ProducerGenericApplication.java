package mx.gob.nayatit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerGenericApplication {

	public static void main(String[] args) {
		System.setProperty("java.security.auth.login.config","/home/ricardoiw/Documents/Library_programs/kafka-cluster/kafka-client-producer/kafka_2.13-2.6.0/config/kafka_client_jaas.conf");
		SpringApplication.run(ProducerGenericApplication.class, args);
	}

}
