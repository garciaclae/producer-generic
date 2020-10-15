package mx.gob.nayatit;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.gob.nayatit.controller.ProducerController;
import mx.gob.nayatit.model.Producer;
import mx.gob.nayatit.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProducerController.class)
class ProducerGenericApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProducerService<Producer> producerService;

	@Test
	void contextLoads() throws Exception {
		Producer producer = new Producer();
		producer.setName("ric");
		producer.setQuota(1);
		Mockito.when(producerService.save(producer)).thenReturn("id:1");
		this.mockMvc.perform(MockMvcRequestBuilders.
				post("/producer")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(producer))
				).
				andExpect(MockMvcResultMatchers.status().isCreated());

	}
}
