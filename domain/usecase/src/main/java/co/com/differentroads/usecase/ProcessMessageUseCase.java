package co.com.differentroads.usecase;

public class ProcessMessageUseCase {

    public void execute(String message) {
        System.out.println("Processing Kafka message: " + message);
        // Add your business logic here to process the message
    }
}