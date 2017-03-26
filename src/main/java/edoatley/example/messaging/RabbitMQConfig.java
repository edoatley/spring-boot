package edoatley.example.messaging;

import java.text.SimpleDateFormat;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RabbitMQConfig {
	 final static String queueName = "new-payments";

	    @Bean
	    Queue queue() {
	        return new Queue(queueName, false);
	    }

	    @Bean
	    TopicExchange exchange() {
	        return new TopicExchange("spring-boot-exchange");
	    }

	    @Bean
	    Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with(queueName);
	    }

	    @Bean
	    MessageConverter messageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }
	    

	    @Bean
	    Jackson2ObjectMapperBuilder objectMapperBuilder() {
	    	Jackson2ObjectMapperBuilder  builder = new Jackson2ObjectMapperBuilder();
	    	builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	    	return builder;
	    }
	    
	    @Bean
	    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	            MessageListenerAdapter listenerAdapter) {
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.setQueueNames(queueName);
	        container.setMessageListener(listenerAdapter);
	        container.setMessageConverter(messageConverter());
	        return container;
	    }

	    
	    
	    @Bean
	    MessageListenerAdapter listenerAdapter(MessageConsumer receiver) {
	        return new MessageListenerAdapter(receiver, "receiveMessage");
	        
	    }
}
