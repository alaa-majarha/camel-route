package com.camel.camelFile.Config;

import jakarta.jms.ConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CamelConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        JmsConnectionFactory factory =
                new JmsConnectionFactory("amqp://localhost:61616");
        factory.setUsername("artemis");
        factory.setPassword("artemis");
        return factory;
    }

    @Bean
    public JmsComponent jmsComponent(ConnectionFactory connectionFactory) {
        return JmsComponent.jmsComponentAutoAcknowledge(connectionFactory);
    }
}


