package edoatley.example.messaging;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edoatley.example.payment.Payment;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	public void receiveMessage(List<Payment> payments) {
		for (Payment payment : payments) {			
			log.error("MessageConsumer.receiveMessage --> " + payment.toString());
		}
	}
} 
