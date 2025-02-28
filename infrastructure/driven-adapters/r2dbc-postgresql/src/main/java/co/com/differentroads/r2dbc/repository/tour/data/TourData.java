package co.com.differentroads.r2dbc.repository.tour.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table("tour")
public class TourData {
    @Id
    private long id;
    private String name;
    private String status;
}
