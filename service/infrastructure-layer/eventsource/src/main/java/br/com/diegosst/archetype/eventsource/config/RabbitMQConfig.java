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
    public Queue archetypeQueue() {
        return new Queue("archetype-queue", true);
    }

    @Bean
    public TopicExchange archetypeExchange() {
        return new TopicExchange("archetype-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(archetypeQueue())
                .to(archetypeExchange())
                .with("archetype-event");
    }

}
