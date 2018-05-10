package com.doddlecode.app.dao;

import com.doddlecode.app.entity.UserAccount;

public interface IUserAccountDAO {
    UserAccount findById(int id);
}
