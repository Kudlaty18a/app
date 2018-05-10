package com.doddlecode.app.dao.impl;

import com.doddlecode.app.dao.AbstractDao;
import com.doddlecode.app.dao.IUserAccountDao;
import com.doddlecode.app.entity.UserAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDao extends AbstractDao<UserAccount> implements IUserAccountDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserAccount findByUsername(String username) {
        UserAccount userAccount = (UserAccount) sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM UserAccount u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();

        return userAccount;
    }

}
