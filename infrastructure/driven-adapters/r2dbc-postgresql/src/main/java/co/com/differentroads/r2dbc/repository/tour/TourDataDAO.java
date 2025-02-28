package co.com.differentroads.r2dbc.repository.tour;

import co.com.differentroads.r2dbc.repository.tour.data.TourData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface TourDataDAO extends ReactiveCrudRepository<TourData, Long>, ReactiveQueryByExampleExecutor<TourData> {

}
