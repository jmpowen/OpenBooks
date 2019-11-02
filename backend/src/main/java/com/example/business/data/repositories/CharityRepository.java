package com.example.business.data.repositories;


import com.example.business.data.entities.Charity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharityRepository extends CrudRepository<Charity, Integer> {

    //add queries

}
