package edoatley.example.messaging;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import edoatley.example.payment.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTest {

	@Autowired
	private MessageProducer messageProducer;
	
	@SpyBean
	private RabbitTemplate rabbitTemplate;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    
	@Test
    public void testSendPaymentsToQueue() throws Exception {
		
		Payment payment = new Payment(LocalDate.of(2017, 3, 1), "Ed", new BigDecimal("15.99"));
		Payment payment2 = new Payment(LocalDate.of(2017, 3, 2), "Ella", new BigDecimal("103.00"));
		Payment payment3 = new Payment(LocalDate.of(2017, 3, 3), "Leo", new BigDecimal("17.85"));
		
		List<Payment> payments = Arrays.asList(payment, payment2, payment3);
		
		messageProducer.sendPaymentsToQueue(payments);
		
		verify(rabbitTemplate).convertAndSend(RabbitMQConfig.queueName, payment);
		verify(rabbitTemplate).convertAndSend(RabbitMQConfig.queueName, payment2);
		verify(rabbitTemplate).convertAndSend(RabbitMQConfig.queueName, payment3);
		
		outputCapture.expect(allOf(containsString(payment.toString())
								 , containsString(payment2.toString())
								 , containsString(payment3.toString())));
	}
}
