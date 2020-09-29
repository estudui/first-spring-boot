package com.userapi.practice.endpoints.delete;

import com.userapi.practice.endpoints.detail.UserNotFoundException;
import com.userapi.practice.user.User;
import com.userapi.practice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService {
    @Autowired
    UserRepository repository;

    public void deleteUser(Long id){
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()){
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
