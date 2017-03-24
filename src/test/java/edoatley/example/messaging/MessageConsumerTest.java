package edoatley.example.messaging;

import static org.mockito.Mockito.verify;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.fasterxml.jackson.databind.ObjectMapper;

import edoatley.example.payment.Payment;

public class MessageConsumerTest {

	// class under test
	@Autowired
	private MessageConsumer messageConsumer;
    
	
	@SpyBean
	private ObjectMapper objectMapper;
	
	
    @Test
    public void testReceiveMessage() throws Exception {
    	InputStream is = this.getClass().getClassLoader().getResourceAsStream("example-payment-message.txt");
    	byte[] payment = IOUtils.toByteArray(is);
    	messageConsumer.receiveMessage(payment);
    	verify(this.objectMapper).readValue(payment, Payment.class);
    }
}
