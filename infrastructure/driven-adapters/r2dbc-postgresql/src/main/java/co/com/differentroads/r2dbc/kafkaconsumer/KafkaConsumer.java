package co.com.differentroads.r2dbc.kafkaconsumer;

import co.com.differentroads.model.procesadormensaje.MessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final MessageProcessor messageProcessor;

    @Autowired
    public KafkaConsumer(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Simulate processing with a use case
        processMessageUseCase.process(message);
    }System.out.println("Processing message with MessageProcessor");
        messageProcessor.process(message);    }
}