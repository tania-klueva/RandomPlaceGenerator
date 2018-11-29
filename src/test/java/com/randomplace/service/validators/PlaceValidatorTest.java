package com.randomplace.service.validators;

import com.randomplace.models.Place;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PlaceValidatorTest {

    @Test
    public void validateNull() {
        List list = mock(List.class);
        PlaceValidator placeValidator = PlaceValidator.getOurInstance();
        placeValidator.validate(null, list);
        verify(list).add(any());

    }

    @Test
    public void validateHalfEmpty() {
        List list = mock(List.class);
        PlaceValidator placeValidator = PlaceValidator.getOurInstance();
        Place place = new Place();
        place.setName("name");
        place.setCity("city");
        placeValidator.validate(place, list);
        verify(list, times(3)).add(any());
    }

    @Test
    public void validateFull() {
        List list = mock(List.class);
        PlaceValidator placeValidator = PlaceValidator.getOurInstance();
        Place place = new Place();
        place.setName("name");
        place.setCity("city");
        place.setDescription("descriiption");
        place.setSpecification("specification");
        place.setAddress("address");
        placeValidator.validate(place, list);
        verify(list, never()).add(any());
    }
}