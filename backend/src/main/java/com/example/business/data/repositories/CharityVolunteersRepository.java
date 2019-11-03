package com.example.business.data.repositories;

import com.example.business.data.entities.CharityVolunteers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharityVolunteersRepository extends CrudRepository<CharityVolunteers, Integer> {

    //add queries
}
