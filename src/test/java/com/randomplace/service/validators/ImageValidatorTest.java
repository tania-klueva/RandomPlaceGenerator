package com.randomplace.service.validators;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ImageValidatorTest {

    ImageValidator imageValidator = ImageValidator.getOurInstance();

    @Test
    public void validateFalse() {
        List list = mock(List.class);
        imageValidator.validate(".opt", list);
        verify(list, times(1)).add(anyString());
    }
    @Test
    public void validate() {
        List list = mock(List.class);
        imageValidator.validate(".jpeg", list);
        verify(list, never()).add(anyString());
    }
}