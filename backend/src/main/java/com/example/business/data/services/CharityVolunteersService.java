package com.example.business.data.services;

import com.example.business.data.entities.CharityVolunteers;
import com.example.business.data.repositories.CharityVolunteersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharityVolunteersService extends AbstractService<CharityVolunteers, Integer>{

    CharityVolunteersRepository charityVolunteersRepository;

    //TODO
}
