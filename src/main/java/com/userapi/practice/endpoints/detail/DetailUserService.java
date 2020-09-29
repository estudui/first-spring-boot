package com.userapi.practice.endpoints.detail;

import com.userapi.practice.user.User;
import com.userapi.practice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@Service
public class DetailUserService {
    @Autowired
    UserRepository repository;

    public Optional<User> listUser(Long id){
        Optional<User> user = repository.findById(id);

        if (user.isPresent()){
            return repository.findById(id);
        } else {
            throw new UserNotFoundException(id);
        }

    }
}
