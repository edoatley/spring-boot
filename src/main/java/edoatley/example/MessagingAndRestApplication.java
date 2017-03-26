package edoatley.example;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Arrays;
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
	
	@Bean
	public Clock clock() {
	    return Clock.systemDefaultZone();
	}
	
	@Autowired
	PaymentRepository paymentRepository;
	
	// 1) Need to switch to use mysql
	// 2) Add security maybe?
	// 3) Any other features?
	@Bean
	public CommandLineRunner init() {
		log.error("Loading data repo");
		return  (evt) -> {
			// need to add code to convert the list into neat Payments to bung into save
			Random rand = new Random();
			String names="Ed Oatley,John Smith,Kate Jones,Roger Gilmartin,Paul Smith,Jane "
					   + "Parsons,Lisa Duncan,Allisa Rain,Mark Anthony,Rebecca Davis,Kara "
			           + "Batty,EmmaWatson,Deborah Milner,Sandy Welyn,Matthew Harding,Chri"
					   + "s Pointer";
			paymentRepository.save(Arrays.asList(names.split(","))
										.stream()
				    					.map(s -> new Payment(LocalDate.now().minusDays(rand.nextInt(50))
				    										 , s
				    										 , BigDecimal.valueOf(rand.nextInt(5000000), 2)))
				    					.collect(Collectors.toList()));
			
		};
	}
}
