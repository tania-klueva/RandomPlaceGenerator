package com.randomplace.service.validators;

import com.randomplace.dto.UserDTO;
import com.randomplace.models.Place;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserValidatorTest {


    UserValidator userValidator = UserValidator.getOurInstance();

    @Test
    public void validateNull() {
        List list = mock(List.class);
        UserDTO user = null;
        userValidator.validate(user, list);
        verify(list, times(1)).add(anyString());
    }
    @Test
    public void validateEmpty() {
        List list = mock(List.class);
        UserDTO user = new UserDTO();
        user.setFirstName("name");
        user.setEmail("email");
        userValidator.validate(user, list);
        verify(list, times(2)).add(anyString());
    }
    @Test
    public void validateFull() {
        List list = mock(List.class);
        UserDTO user = new UserDTO();
        user.setEmail("email");
        user.setFirstName("name");
        user.setLastName("name");
        user.setCity("Lviv");
        userValidator.validate(user, list);
        verify(list, never()).add(anyString());
    }

    @Test
    public void isNullOrEmptyWithEmptyString() {
        assertTrue(userValidator.isNullOrEmpty(""));
    }
    @Test
    public void isNullOrEmptyWithNull() {
        assertTrue(userValidator.isNullOrEmpty(null));
    }
    @Test
    public void isNullOrEmpty() {
        assertFalse(userValidator.isNullOrEmpty("lol"));
    }

    @Test
    public void validatePasswordsNull() {
        List list = mock(List.class);
        UserDTO user = null;
        userValidator.validatePasswords(user, list);
        verify(list, times(1)).add(anyString());
        assertFalse(userValidator.validatePasswords(user, list));
    }
    @Test
    public void validatePasswordsLength() {
        List list = mock(List.class);
        UserDTO user = new UserDTO();
        user.setNewPassword("12345");
        userValidator.validatePasswords(user, list);
        verify(list, times(1)).add(anyString());
        assertFalse(userValidator.validatePasswords(user, list));
    }
    @Test
    public void validatePasswordsNotMatches() {
        List list = mock(List.class);
        UserDTO user = new UserDTO();
        user.setNewPassword("123456");
        user.setConfirmPassword("1234566");
        userValidator.validatePasswords(user, list);
        verify(list, never()).add(anyString());
        assertFalse(userValidator.validatePasswords(user, list));
    }
    @Test
    public void validatePasswords() {
        List list = mock(List.class);
        UserDTO user = new UserDTO();
        user.setNewPassword("123456");
        user.setConfirmPassword("123456");
        userValidator.validatePasswords(user, list);
        verify(list, never()).add(anyString());
        assertTrue(userValidator.validatePasswords(user, list));
    }
}