package br.com.diegosst.archetype.eventsource.consumer;

import br.com.diegosst.archetype.adapter.output.SimpleEventSource;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleEventConsumer {

    private static final String QUEUE_NAME = "simple-queue";

    private final SimpleEventSource simpleEventSource;

    @RabbitListener(queues = QUEUE_NAME)
    public void handleBaseEntityEvent(final BaseEntityEvent event) {
        simpleEventSource.storeBaseEntity(event);
    }
}
