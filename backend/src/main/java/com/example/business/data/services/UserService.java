package com.example.business.data.services;

import com.example.business.data.entities.User;
import com.example.business.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, String> {

}