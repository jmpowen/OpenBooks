package com.example.business.data.services;

import com.example.business.data.entities.Donation;
import com.example.business.data.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService extends AbstractService<Donation, Integer>{

    @Autowired
    DonationRepository donationRepository;

    //todo
}
