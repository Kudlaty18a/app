package com.doddlecode.app.dao.impl;

import com.doddlecode.app.dao.IUserAccountDAO;
import com.doddlecode.app.entity.UserAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDAO {
    @Autowired
    SessionFactory sessionFactory;

    public UserAccount findById(int id) {
        UserAccount userAccount = null;

        userAccount = (UserAccount) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM UserAccount u WHERE u.userId = :id")
                .setParameter("id", id)
                .getSingleResult();

        return userAccount;
    }

}
