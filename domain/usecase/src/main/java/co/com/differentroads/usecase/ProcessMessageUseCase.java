package co.com.differentroads.usecase;

import co.com.differentroads.model.procesadormensaje.MessageProcessor;

public class ProcessMessageUseCase implements MessageProcessor {

    @Override
    public void process(String message) {
        System.out.println("Processing Kafka message: " + message);
        // Add your business logic here to process the message
    }