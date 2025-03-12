package co.com.differentroads.api;

import co.com.differentroads.model.tour.Tour;
import co.com.differentroads.model.tour.gateways.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
private  final TourRepository tourRepository;

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
}
