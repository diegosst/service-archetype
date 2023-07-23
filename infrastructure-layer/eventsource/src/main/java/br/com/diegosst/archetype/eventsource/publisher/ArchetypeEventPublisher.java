package br.com.diegosst.archetype.eventsource.publisher;

import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArchetypeEventPublisher {
    private final AmqpTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void publishEntity(final BaseEntityEvent event) throws JsonProcessingException {
        final String message = objectMapper.writeValueAsString(event);
        rabbitTemplate.convertAndSend("archetype-exchange", "archetype-event", message);
    }
}
