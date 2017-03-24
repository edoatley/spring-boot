package edoatley.example.messaging;

import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import edoatley.example.payment.Payment;

@Component
public class MessageConsumer {
	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	public void receiveMessage(byte[] payment) throws IOException {
	
		//log.error("MessageConsumer.receiveMessage(byte[]) --> " + new String(payment));
		Payment pay = objectMapper.readValue(payment, Payment.class);
		log.error("receiveMessage(byte[]) --> " + pay.toString());

	}
} 
