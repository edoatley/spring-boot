package edoatley.example.messaging;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	public void receiveMessage(List<String> messages) {
		for (String message : messages) {			
			log.error("MessageConsumer.receiveMessage --> " + message);
		}
	}
} 
