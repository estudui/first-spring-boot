package com.userapi.practice.endpoints.update;

import com.userapi.practice.endpoints.detail.UserNotFoundException;
import com.userapi.practice.user.User;
import com.userapi.practice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService {
    @Autowired
    UserRepository repository;

    public User updateUser(Long id, User user){
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()){
            repository.findById(id);

            return repository.save(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
