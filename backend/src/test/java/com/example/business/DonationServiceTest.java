package com.example.business;

import com.example.business.data.entities.User;
import com.example.business.data.repositories.UserRepository;
import com.example.business.data.services.DonationService;
import com.example.business.data.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class DonationServiceTest {

    @InjectMocks
    DonationService donationService;

    @Mock
    UserRepository repo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDonationById() {

    }

    @Test
    public void getDonationByUser(){

    }

    @Test
    public void getDonationByCharity(){

    }

}
