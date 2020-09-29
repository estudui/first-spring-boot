package com.userapi.practice.endpoints.create;

import com.userapi.practice.user.User;
import com.userapi.practice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserRepository repository;

    public User createNewUser(User user){
        return repository.save(user);
    }

}
