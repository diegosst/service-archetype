package br.com.diegosst.archetype.eventsource.consumer;

import br.com.diegosst.archetype.adapter.output.SimpleEventSource;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleEventConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleEventConsumer.class);

    private static final String QUEUE_NAME = "simple-queue";

    private final SimpleEventSource simpleEventSource;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = QUEUE_NAME)
    public void handleBaseEntityEvent(final String message) {
        try {
            simpleEventSource.storeBaseEntity(objectMapper.readValue(message, BaseEntityEvent.class));
        } catch (JsonProcessingException e) {
            LOG.error("Could not process message as Base Entity Event.", e);
        }
    }
}
