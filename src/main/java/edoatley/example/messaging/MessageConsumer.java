package edoatley.example.messaging;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edoatley.example.payment.Payment;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Autowired
	private Jackson2JsonMessageConverter objectMapper;
	
	public void receiveMessage(Message m) throws IOException {
		Payment pay = (Payment) objectMapper.fromMessage(m);
		log.error("receiveMessage(Message) --> " + pay.toString());
	}
//	public void receiveMessage(byte[] payment) throws IOException {

	//	public void receiveMessage(byte[] payment) throws IOException {
//	
//		//log.error("MessageConsumer.receiveMessage(byte[]) --> " + new String(payment));
//		Payment pay = objectMapper.fromMessage(payment);
//
//	}
} 
