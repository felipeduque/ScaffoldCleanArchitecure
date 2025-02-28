package co.com.differentroads.model.tour;
import co.com.differentroads.model.exceptions.BusinessException;
import co.com.differentroads.model.exceptions.message.BusinessErrorMessage;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import static co.com.differentroads.model.exceptions.message.BusinessErrorMessage.TOUR_VALIDATION;

@Getter
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tour {
    private final Long id;
    private final String name;
    private final String status;

    public static Tour newTour(long id, String name, String status) {
        if (name.equals("error"))
            throw new BusinessException(TOUR_VALIDATION);
        return new Tour(id, name, status);
    }
}
