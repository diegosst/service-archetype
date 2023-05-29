package br.com.diegosst.archetype.eventsource.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue("simple-queue", true);
    }

    @Bean
    public TopicExchange simpleExchange() {
        return new TopicExchange("simple-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(simpleQueue())
                .to(simpleExchange())
                .with("simple-event");
    }

}
