package com.example.business.data.services;

import com.example.business.data.entities.Volunteers;
import com.example.business.data.repositories.VolunteersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteersService extends AbstractService<Volunteers, Integer>{

    VolunteersRepository volunteersRepository;

    //TODO
}
