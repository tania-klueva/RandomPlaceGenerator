package com.randomplace.service.image;

import com.randomplace.service.validators.ImageValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.Part;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {

    @Mock
    ImageValidator mockValidator;
    @InjectMocks
    ImageService imageService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getContentType() {
        Part mockPart = mock(Part.class);
        when(mockPart.getSubmittedFileName()).thenReturn("image.jpg");
        assertEquals(imageService.getContentType(mockPart), ".jpg");
    }

}