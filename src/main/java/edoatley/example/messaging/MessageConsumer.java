package edoatley.example.messaging;

import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	public void receiveMessage(String message) {
		System.out.println("MessageConsumer.receiveMessage --> " + message);
	}
} 
