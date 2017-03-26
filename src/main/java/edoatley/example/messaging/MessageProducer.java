package edoatley.example.messaging;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import edoatley.example.payment.Payment;

@Component
public class MessageProducer {
	
	private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
	
	private RabbitTemplate rabbitTemplate; 
    
	public MessageProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendPaymentsToQueue(List<Payment> payments) {
		for (Payment payment : payments) {
			log.debug("sendPaymentsToQueue() sending --> " + payment); 
			rabbitTemplate.convertAndSend(RabbitMQConfig.queueName, payment);
		}
	}
} 
