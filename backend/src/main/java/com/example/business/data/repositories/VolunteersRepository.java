package com.example.business.data.repositories;

import com.example.business.data.entities.Volunteers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteersRepository extends CrudRepository<Volunteers, Integer> {

    //add queries
}
