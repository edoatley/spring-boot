package edoatley.example.messaging;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edoatley.example.mock.FixedClock;
import edoatley.example.rest.PaymentController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixedClock
public class PaymentControllerTest {

	// class under test
	@Autowired
	private PaymentController paymentController;
	
	@MockBean
	private RabbitTemplate rabbitTemplate; 
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }
    
    @Test
    public void testAddNewPayment() throws Exception {
    	InputStream is = this.getClass().getClassLoader().getResourceAsStream("payments-small.json");
    	String requestJson = IOUtils.toString(is);
    	InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("payments-small-response.json");
    	String responseJson = IOUtils.toString(is2);
    	
    	this.mockMvc.perform(post("/asyncAddPayments")
    							.content(requestJson)
    							.contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
    							.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                			.andExpect(status().isOk())
                			.andDo(print())	// can comment out once happy with the result!
                			.andExpect(content().json(responseJson))
                			;
       
    }
}
