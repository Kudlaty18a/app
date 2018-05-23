package com.doddlecode.app.dao.impl;

import com.doddlecode.app.dao.AbstractDao;
import com.doddlecode.app.dao.IUserAccountDao;
import com.doddlecode.app.entity.UserAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserAccountDao extends AbstractDao<UserAccount> implements IUserAccountDao {

    public UserAccount findById(int id) {
        UserAccount userAccount = null;

        userAccount = (UserAccount) getCurrentSession()
                .createQuery("SELECT u FROM UserAccount u WHERE u.userId = :id")
                .setParameter("id", id)
                .getSingleResult();

        return userAccount;
    }

    @Override
    public UserAccount findByUsername(String username) {
        UserAccount userAccount = null;

        userAccount = (UserAccount) getCurrentSession()
                .createQuery("SELECT u FROM UserAccount u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();

        return userAccount;
    }
}
