package com.doddlecode.app.dao;

import com.doddlecode.app.entity.UserAccount;

public interface IUserAccountDao {
    UserAccount findById(int id);
    void save(UserAccount user);
    UserAccount findByUsername(String username);
}
