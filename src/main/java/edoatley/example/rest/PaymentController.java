package edoatley.example.rest;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edoatley.example.messaging.MessageProducer;
import edoatley.example.payment.Payment;
import edoatley.example.payment.PaymentReceivedConfirmation;

@RestController
public class PaymentController {
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	
	private final MessageProducer messageProducer;
	private final Clock clock;
	
	public PaymentController(MessageProducer messageProducer, Clock clock) {
		this.messageProducer = messageProducer;
		this.clock = clock;
		log.error("Clock class[{}] + clock[{}]", clock.getClass(), clock);
	}
	
	@RequestMapping(path="/asyncAddPayments")
	public @ResponseBody PaymentReceivedConfirmation addNewPayment(@RequestBody Payment[] payments) {
		log.error("Received payments at /asyncAddPayments total number=" + payments.length + " 1st payment="+payments[0].toString());
		messageProducer.sendPaymentsToQueue(Arrays.asList(payments));
		return new PaymentReceivedConfirmation(payments.length, true, ZonedDateTime.now(clock));
	}
}
