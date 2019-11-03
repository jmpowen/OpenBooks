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
        when(repo.findById("TomDodge@gmail.com")).thenReturn(Optional.of((new User(	("TomDodge@gmail.com"), "TomDodge", "Tom Dodge, Tom Dodge, Tom Dodge"))));

        User userFound = userService.getEntityByID("TomDodge@gmail.com").get();

        assertEquals("TomDodge@gmail.com", userFound.getUser_email());
    }

    @Test
    public void createUserTest() {
        User toAdd = new User("thisGuy@gmail.com", "admin", "Some bio");
        when(repo.existsById("thisGuy@gmail.com")).thenReturn(false);
        when(repo.save(toAdd)).thenReturn(new User());

        ResponseEntity<?> response = userService.createEntity(toAdd, toAdd.getUser_email());

        verify(repo, times(1)).save(toAdd);
        assertThat(repo.save(toAdd), is(notNullValue()));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), toAdd.getClass().getSimpleName());
    }

    @Test
    public void createUserTest_fail() {
        User alreadyInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");
        alreadyInDB.setUser_email("TomDodge@gmail.com");
        when(repo.existsById("TomDodge@gmail.com")).thenReturn(true);

        ResponseEntity<?> response = userService.createEntity(alreadyInDB, alreadyInDB.getUser_email());

        verify(repo, never()).save(alreadyInDB);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), alreadyInDB.getClass().getSimpleName());
    }

    @Test
    public void deleteUserTest() {
        User toDelete = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");


        when(repo.existsById(toDelete.getUser_email())).thenReturn(true);
        when(repo.findById(toDelete.getUser_email())).thenReturn(Optional.of(toDelete));

        ResponseEntity<?> response = userService.deleteEntityById(toDelete.getUser_email());
        verify(repo, times(1)).deleteById(toDelete.getUser_email());

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), toDelete.getClass().getSimpleName());
    }


    @Test
    public void editUserTest() {
        User userInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");

        when(repo.save(userInDB)).thenReturn(new User());
        when(repo.existsById(userInDB.getUser_email())).thenReturn(true);

        ResponseEntity<?> response = userService.editEntity(userInDB, userInDB.getUser_email());

        assertThat(repo.save(userInDB), is(notNullValue()));

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), userInDB.getClass().getSimpleName());
    }

    @Test
    public void editUserTest_Fail() {
        User userNotInDB = new User("TomDodge@gmail.com", "The Dude", "The Hami Bambi So-Samie. The Original Rocketeer, and biographer of the Chinese Alamanc.");

        when(repo.existsById(userNotInDB.getUser_email())).thenReturn(false);

        ResponseEntity<?> response = userService.editEntity(userNotInDB, userNotInDB.getUser_email());

        verify(repo, never()).save(userNotInDB);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(response.getBody(), userNotInDB.getClass().getSimpleName());
    }


    @Test
    public void deleteUserTest_Fail() {
        when(repo.existsById("someYoungGuy@gmail.com")).thenReturn(false);

        ResponseEntity<?> response = userService.deleteEntityById("someYoungGuy@gmail.com");
        verify(repo, never()).deleteById("someYoungGuy@gmail.com");

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
    }

    @Test
    public void deleteUserTest_Exception() {
        when(repo.existsById("someYoungGuy@gmail.com")).thenThrow(IllegalArgumentException.class);

        ResponseEntity<?> response = userService.deleteEntityById("someYoungGuy@gmail.com");
        verify(repo, never()).deleteById("someYoungGuy@gmail.com");

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
    }

}
