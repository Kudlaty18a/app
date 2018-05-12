package com.doddlecode.app.service;

import com.doddlecode.app.dao.impl.RoleDao;
import com.doddlecode.app.dao.impl.UserAccountDao;
import com.doddlecode.app.entity.Role;
import com.doddlecode.app.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserAccountDao userAccountDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserAccount user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleDao.findById(1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);

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
