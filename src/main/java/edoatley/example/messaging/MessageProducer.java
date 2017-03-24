package edoatley.example.messaging;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edoatley.example.payment.Payment;

@Component
public class MessageProducer {
	
	private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);
	
	private RabbitTemplate rabbitTemplate; 
    private ObjectMapper mapper;
    
	public MessageProducer(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.mapper = mapper;
	}

	public void sendPaymentsToQueue(List<Payment> payments) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.queueName, payments);
	}
} 
