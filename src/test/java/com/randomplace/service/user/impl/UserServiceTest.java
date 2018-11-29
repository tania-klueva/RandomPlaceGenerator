package com.randomplace.service.user.impl;

import com.randomplace.dao.impl.UserDAO;
import com.randomplace.dto.UserDTO;
import com.randomplace.service.validators.UserValidator;
import com.randomplace.utils.PasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    UserDAO userDAO;
    @Mock
    UserValidator userValidator;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    UserService userService;

    public UserDTO createUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setFirstName("name");
        userDTO.setLastName("name");
        userDTO.setEmail("test");
        userDTO.setCity("test");
        userDTO.setNewPassword("testtest");
        userDTO.setConfirmPassword("testtest");
        return userDTO;
    }

    @Test
    public void save() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(mockList.isEmpty()).thenReturn(true);
        when(userValidator.validatePasswords(any(), any())).thenReturn(true);
        when(userDAO.findByEmail(any())).thenReturn(null);
        userService.save(userDTO, mockList);
        verify(userValidator).validatePasswords(userDTO, mockList);
        verify(userValidator).validate(userDTO, mockList);
        verify(userDAO).findByEmail(any());
        verify(userDAO).save(any());

    }

    @Test
    public void findByEmail() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(userValidator.isNullOrEmpty(any())).thenReturn(false);
        userService.findByEmail(userDTO, mockList);
        verify(userDAO).findByEmail(any());
    }

    @Test
    public void findById() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(userValidator.isNullOrEmpty(any())).thenReturn(false);
        userService.findById(userDTO, mockList);
        verify(userDAO).findById(anyInt());
    }

    @Test
    public void findAll() {

        userService.findAll();
        verify(userDAO).findAll();
    }

    @Test
    public void update() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(mockList.isEmpty()).thenReturn(true);
        userService.update(userDTO, mockList);
        verify(userDAO).update(any());
    }

    @Test
    public void updatePassword() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(userValidator.validatePasswords(any(), any())).thenReturn(true);
        when(mockList.isEmpty()).thenReturn(true);
        when(passwordEncoder.isMatches(any())).thenReturn(true);
        userService.updatePassword(userDTO, mockList);
        verify(userDAO).updatePassword(any());
    }

    @Test
    public void deleteById() {
        List mockList = mock(List.class);
        UserDTO userDTO = createUser();
        when(userValidator.isNullOrEmpty(any())).thenReturn(false);
        userService.deleteById(userDTO, mockList);
        verify(userDAO).deleteById(anyInt());
    }
}