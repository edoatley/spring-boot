package edoatley.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingAndRestApplication {

	private static final Logger log = LoggerFactory.getLogger(MessagingAndRestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingAndRestApplication.class, args);
	}
	
	
}
