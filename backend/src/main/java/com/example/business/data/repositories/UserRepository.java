package com.example.business.data.repositories;


import com.example.business.data.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE user_email = ?1", nativeQuery = true)
    User findUserByEmail(String user_email);
}