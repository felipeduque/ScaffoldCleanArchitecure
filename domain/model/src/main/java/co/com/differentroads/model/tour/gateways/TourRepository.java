package co.com.differentroads.model.tour.gateways;

import co.com.differentroads.model.tour.Tour;
import reactor.core.publisher.Mono;

public interface TourRepository {
    Mono<Tour> findById(long id);
}
