package com.doddlecode.app.dao;

public interface IUserAccountDao {
    UserAccount findByUsername(String username);
}
