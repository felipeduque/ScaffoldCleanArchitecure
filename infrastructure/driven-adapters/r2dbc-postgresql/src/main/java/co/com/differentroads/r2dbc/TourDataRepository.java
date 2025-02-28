package co.com.differentroads.r2dbc;

import co.com.differentroads.model.tour.Tour;
import co.com.differentroads.model.tour.gateways.TourRepository;
import co.com.differentroads.r2dbc.repository.tour.TourDataDAO;
import co.com.differentroads.r2dbc.repository.tour.data.TourData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class TourDataRepository implements TourRepository {
    private final TourDataDAO repository;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Tour> findById(long id) {
        return repository.findById(id)
                .map(this::toEntity);
    }

    private Tour toEntity(TourData data) {
        return objectMapper.mapBuilder(data, Tour.TourBuilder.class).build();
    }

    private TourData toData(Tour entity) {
        return objectMapper.map(entity, TourData.class);
    }
}
