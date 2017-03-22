package edoatley.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edoatley.example.payment.Payment;
import edoatley.example.persist.PaymentRepository;

@SpringBootApplication
public class MessagingAndRestApplication {

	private static final Logger log = LoggerFactory.getLogger(MessagingAndRestApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingAndRestApplication.class, args);
	}
	
	@Autowired
	PaymentRepository paymentRepository;

	@Bean
	public CommandLineRunner init() {
		log.error("Loading data repo");
		return  (evt) -> {
			// need to add code to convert the list into neat Payments to bung into save
			Random rand = new Random();
			List<String> listOfNamesToGeneratePaymentsFor = Arrays.asList("name1", "name2", "name3");
			paymentRepository.save(listOfNamesToGeneratePaymentsFor
										.stream()
				    					.map(s -> new Payment(LocalDate.now(), s, BigDecimal.valueOf(rand.nextInt(5000000), 2)))
				    					.collect(Collectors.toList()));
			
		};
	}
}
