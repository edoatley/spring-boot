package edoatley.example.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edoatley.example.payment.Payment;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	public void receiveMessage(Payment payment) {
		log.error("MessageConsumer.receiveMessage(Payment) --> " + payment.toString());
	}
	public void receiveMessage(String payment) {
		log.error("MessageConsumer.receiveMessage(String) --> " + payment);
	}
} 
