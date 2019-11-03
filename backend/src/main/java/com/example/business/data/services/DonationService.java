package com.example.business.data.services;

import com.example.business.data.entities.Donation;
import com.example.business.data.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DonationService extends AbstractService<Donation, Integer>{

    @Autowired
    DonationRepository donationRepository;

    public Page<Donation> userSearch(String user_email, Pageable pageable){
        return donationRepository.getDonationListByUser(user_email, pageable);
    }

    public Page<Donation> charitySearch(int charity_id, Pageable pageable){
        return donationRepository.getDonationListByCharity(charity_id, pageable);
    }

}
