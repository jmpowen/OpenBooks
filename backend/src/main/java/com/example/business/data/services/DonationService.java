package com.example.business.data.services;

import com.example.business.data.entities.Donation;
import com.example.business.data.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DonationService extends AbstractService<Donation, Integer>{

    @Autowired
    DonationRepository donationRepository;

    public Page<Donation> userSearch(String user_email, Pageable pageable){
        return donationRepository.getDonationListByUser(user_email, pageable);
    }

    public Page<Donation> propertySearch(String property, Sort.Direction direction, int page, int size){
        Sort howToSort = Sort.by(direction, property);
        Pageable pageable = PageRequest.of(page, size, howToSort);
        return donationRepository.findAll(pageable);
    }

    public Page<Donation> charitySearch(int charity_id, Pageable pageable){
        return donationRepository.getDonationListByCharity(charity_id, pageable);
    }

}
