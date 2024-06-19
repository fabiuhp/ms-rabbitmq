package com.fabiopereira.email.consumer;

import com.fabiopereira.email.EmailRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listen(@Payload EmailRecord email) {
        System.out.println(email.emailTo());
    }
}
