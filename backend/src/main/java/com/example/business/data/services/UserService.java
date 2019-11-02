package com.example.business.data.services;

import com.example.business.data.entities.User;
import com.example.business.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, Integer> {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String user_email){
        return userRepository.findUserByEmail(user_email);
    }

    public boolean userExistsByEmail(String user_email){
        return getUserByEmail(user_email) == null;
    }
}