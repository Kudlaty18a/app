package com.doddlecode.app.service;

import com.doddlecode.app.dao.impl.UserAccountDao;
import com.doddlecode.app.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserAccountDao userAccountDao;

    public void save(UserAccount user) {
        userAccountDao.save(user);
    }

    public UserAccount update(UserAccount user) {
        return userAccountDao.update(user);
    }

    public UserAccount find(String username) {
        return userAccountDao.findByUsername(username);
    }

    public UserAccount find(int id) {
        return userAccountDao.findOne(id);
    }

}
