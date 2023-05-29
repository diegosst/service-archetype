package br.com.diegosst.archetype.eventsource.publisher;

import br.com.diegosst.archetype.event.BaseEntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleEventPublisher {
    private final AmqpTemplate rabbitTemplate;

    public void publishEntity(final BaseEntityEvent event) {
        rabbitTemplate.convertAndSend("simple-exchange", "simple-event", event);
    }
}
