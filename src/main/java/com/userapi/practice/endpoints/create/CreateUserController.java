package com.userapi.practice.endpoints.create;

import com.userapi.practice.endpoints.delete.DeleteUserController;
import com.userapi.practice.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class CreateUserController {
    @Autowired

    CreateUserService service;
    final Logger log = LoggerFactory.getLogger(CreateUserController.class);
//    final org.apache.logging.log4j.Logger logger = LogManager.getLogger(StringFormatterMessageFactory.INSTANCE);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createNewUser_whenPostUser(@RequestBody User user){
        log.info("UserData : " + user);
//        logger.debug("data" + user);
        User createdUser = service.createNewUser(user);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.toString())
                .toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }
}
