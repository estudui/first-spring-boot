package com.userapi.practice.endpoints.lists;

import com.userapi.practice.user.User;
import com.userapi.practice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {
    @Autowired
    UserRepository repository;

    public List<User> listAllUsers(){
        return repository.findAll();
    }
}
