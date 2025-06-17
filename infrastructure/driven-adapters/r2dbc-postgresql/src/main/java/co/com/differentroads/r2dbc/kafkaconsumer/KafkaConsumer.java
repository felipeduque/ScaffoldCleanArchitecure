package co.com.differentroads.r2dbc.kafkaconsumer;

import co.com.differentroads.usecase.ProcessMessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final ProcessMessageUseCase processMessageUseCase;

    @Autowired
    public KafkaConsumer(ProcessMessageUseCase processMessageUseCase) {
        this.processMessageUseCase = processMessageUseCase;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Simulate processing with a use case
        processMessageUseCase.process(message);
    }
}