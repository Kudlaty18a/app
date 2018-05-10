package com.doddlecode.app.dao;

import com.doddlecode.app.entity.UserAccount;

public interface IUserAccountDao {
    UserAccount findByUsername(String username);
}
