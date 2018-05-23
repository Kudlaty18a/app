package com.doddlecode.app.controller;

import com.doddlecode.app.dao.impl.UserAccountDao;
import com.doddlecode.app.entity.UserAccount;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserAccountDao userAccountDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserAccountDao userAccountDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userAccountDao = userAccountDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserAccount user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAccountDao.save(user);
    }

    @RequestMapping("/users")
    public @ResponseBody String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }
}
