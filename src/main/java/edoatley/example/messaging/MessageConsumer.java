package edoatley.example.messaging;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import edoatley.example.payment.Payment;
import edoatley.example.persist.PaymentRepository;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
  	public void receiveMessage(byte[] paymentMessage) throws IOException {

		log.info("receiveMessage() -->  input [" + new String(paymentMessage) + "]");
		
		Payment payment = objectMapper.readValue(paymentMessage, Payment.class);
		log.info("receiveMessage() --> output [" + payment.toString() + "]");
		
		Payment savedPayment = paymentRepository.save(payment);
		log.info("receiveMessage() -->  saved [" + savedPayment.toString() + "]");
		
  	}
} 
