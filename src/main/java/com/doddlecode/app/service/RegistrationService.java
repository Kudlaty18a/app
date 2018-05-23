package com.doddlecode.app.service;

import com.doddlecode.app.dao.impl.RoleDao;
import com.doddlecode.app.dao.impl.UserAccountDao;
import com.doddlecode.app.entity.Role;
import com.doddlecode.app.entity.UserAccount;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RegistrationService {

    private UserAccountDao userAccountDao;
    private RoleDao roleDao;

    public RegistrationService(UserAccountDao userAccountDao, RoleDao roleDao) {
        this.userAccountDao = userAccountDao;
        this.roleDao = roleDao;
    }

    public void saveUser(UserAccount userAccount) {
        Role role = this.roleDao.findByName("USER");
        Set roles = Sets.newHashSet(role);

        userAccount.setRoles(roles);

        this.userAccountDao.save(userAccount);
    }

}
