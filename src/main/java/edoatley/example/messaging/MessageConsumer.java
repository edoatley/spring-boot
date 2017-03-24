package edoatley.example.messaging;

import java.util.List;

import org.springframework.stereotype.Component;

import edoatley.example.payment.Payment;

@Component
public class MessageConsumer {

	public void receiveMessage(List<Payment> message) {
		System.out.println("MessageConsumer.receiveMessage --> " + message);
	}
} 
