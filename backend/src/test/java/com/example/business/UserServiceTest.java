package com.example.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.business.data.entities.User;
import com.example.business.data.repositories.UserRepository;
import com.example.business.data.services.UserService;
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserByEmailTest() {
        when(repo.findUserByEmail("TomDodge@gmail.com")).thenReturn(new User(	("TomDodge@gmail.com"), "TomDodge", "Tom Dodge, Tom Dodge, Tom Dodge"));

        User userFound = userService.getUserByEmail("TomDodge@gmail.com");

        assertEquals("TomDodge@gmail.com", userFound.getUser_email());
    }

    @Test
    public void createUserTest_fail() {
        User alreadyInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");
        alreadyInDB.setUser_id(100000);
        when(repo.existsById(100000)).thenReturn(true);

        ResponseEntity<?> response = userService.createEntity(alreadyInDB, alreadyInDB.getUser_id());

        verify(repo, never()).save(alreadyInDB);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), alreadyInDB.getClass().getSimpleName());
    }

    @Test
    public void deleteUserTest() {
        User toDelete = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");


        when(repo.existsById(toDelete.getUser_id())).thenReturn(true);
        when(repo.findById(toDelete.getUser_id())).thenReturn(Optional.of(toDelete));

        ResponseEntity<?> response = userService.deleteEntityById(toDelete.getUser_id());
        verify(repo, times(1)).deleteById(toDelete.getUser_id());

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), toDelete.getClass().getSimpleName());
    }


    @Test
    public void editUserTest() {
        User userInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");

        when(repo.save(userInDB)).thenReturn(new User());
        when(repo.existsById(userInDB.getUser_id())).thenReturn(true);

        ResponseEntity<?> response = userService.editEntity(userInDB, userInDB.getUser_id());

        assertThat(repo.save(userInDB), is(notNullValue()));

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), userInDB.getClass().getSimpleName());
    }

    @Test
    public void editUserTest_Fail() {
        User userNotInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");

        when(repo.existsById(userNotInDB.getUser_id())).thenReturn(false);

        ResponseEntity<?> response = userService.editEntity(userNotInDB, userNotInDB.getUser_id());

        verify(repo, never()).save(userNotInDB);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), userNotInDB.getClass().getSimpleName());
    }


    @Test
    public void deleteUserTest_Fail() {
        when(repo.existsById(1000)).thenReturn(false);

        ResponseEntity<?> response = userService.deleteEntityById(1000);
        verify(repo, never()).deleteById(1000);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
    }

    @Test
    public void deleteUserTest_Exception() {
        when(repo.existsById(1000)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<?> response = userService.deleteEntityById(1000);
        verify(repo, never()).deleteById(1000);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
    }

}
