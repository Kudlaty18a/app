package com.doddlecode.app.service;

import com.doddlecode.app.dao.impl.UserAccountDAO;
import com.doddlecode.app.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserAccountDAO userAccountDAO;

    public UserAccount findUser(int id) {
        return userAccountDAO.findById(id);
    }

}
