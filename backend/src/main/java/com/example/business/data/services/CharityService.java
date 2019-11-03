package com.example.business.data.services;

import com.example.business.data.entities.Charity;
import com.example.business.data.repositories.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CharityService extends AbstractService<Charity, Integer> {

    @Autowired
    CharityRepository charityRepository;

    //todo

}
