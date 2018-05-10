package com.doddlecode.app.controller;

import com.doddlecode.app.entity.UserAccount;
import com.doddlecode.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public UserAccount find() {
        UserAccount user = userService.findUser(1);
        return user;
    }


}
