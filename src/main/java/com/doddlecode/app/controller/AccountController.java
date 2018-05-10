package com.doddlecode.app.controller;

import com.doddlecode.app.entity.UserAccount;
import com.doddlecode.app.service.UserService;
import com.doddlecode.app.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("account")
public class AccountController {

    public static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserAccount newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            log.error("username already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + " already exist"),
                    HttpStatus.CONFLICT
            );

        }

        newUser.setRole("USER");

        return new ResponseEntity<UserAccount>(userService.update(newUser), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        log.info("user logged " + principal);
        return principal;
    }

}
