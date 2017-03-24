package edoatley.example.rest;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edoatley.example.messaging.MessageProducer;
import edoatley.example.payment.Payment;

@RestController
public class PaymentController {

	private final MessageProducer messageProducer;
	
	PaymentController(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}
	@RequestMapping(path="/asyncAddPayment")
	public @ResponseBody PaymentReceievedConfirmmation addNewPayment(@RequestBody List<Payment> payments) {
		
		messageProducer.sendPaymentsToQueue(payments);
		return new PaymentReceievedConfirmmation(payments.size(), true, ZonedDateTime.now());
				
	}
}
