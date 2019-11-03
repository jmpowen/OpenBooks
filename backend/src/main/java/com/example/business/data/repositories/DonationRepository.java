package com.example.business.data.repositories;

import com.example.business.data.entities.Donation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer> {

    //add queries
}
