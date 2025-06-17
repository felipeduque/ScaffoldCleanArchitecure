package co.com.differentroads.api;

import co.com.differentroads.model.tour.Tour;
import co.com.differentroads.model.tour.gateways.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
private  final TourRepository tourRepository;
private final KafkaProducer kafkaProducer;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("Hello");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        return tourRepository.findById(4000)
                //.flatMap(tour -> ServerResponse.ok().bodyValue(tour));
                .flatMap(tour -> {
                    Map<String, List<Tour>> response = Map.of("tours", List.of(tour));
                    return ServerResponse.ok().bodyValue(response);
                });
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTToKafka(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(String.class)
                .doOnNext(message -> kafkaProducer.sendMessage("my-topic", message))
                .flatMap(message -> ServerResponse.ok().bodyValue("Message sent to Kafka: " + message))
                .onErrorResume(e -> ServerResponse.badRequest().bodyValue("Error sending message to Kafka: " + e.getMessage()));
    }
}
