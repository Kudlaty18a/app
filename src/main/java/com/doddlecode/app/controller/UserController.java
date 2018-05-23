package com.doddlecode.app.controller;

import com.doddlecode.app.dao.impl.UserAccountDao;
import com.doddlecode.app.entity.Role;
import com.doddlecode.app.entity.UserAccount;
import com.doddlecode.app.service.RegistrationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private RegistrationService registrationService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(RegistrationService registrationService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.registrationService = registrationService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody UserAccount user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        registrationService.saveUser(user);
    }

}
