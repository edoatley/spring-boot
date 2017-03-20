package edoatley.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MessagingAndRestApplication {

	private static final Logger log = LoggerFactory.getLogger(MessagingAndRestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingAndRestApplication.class, args);
	}
	
//	public CommandLineRunner init(String... args) {
//		return  (evt) -> {
//			ObjectMapper objectMapper = new ObjectMapper();
//			log.debug("Calling CommandLineRunner to init objectMapper");
//			objectMapper.findAndRegisterModules();
//			Jackson2ObjectMapperBuilder.json()
//		    .featuresToDisable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
//		};
//	}
}
