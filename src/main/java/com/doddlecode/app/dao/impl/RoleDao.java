package com.doddlecode.app.dao.impl;

import com.doddlecode.app.dao.AbstractDao;
import com.doddlecode.app.dao.IRoleDao;
import com.doddlecode.app.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends AbstractDao<Role> implements IRoleDao {
    @Override
    public Role findById(Integer id) {
        Role role = (Role) getCurrentSession()
                .createQuery("FROM Role r WHERE r.roleId = :id")
                .setParameter("id", id)
                .getSingleResult();

        return role;
    }
}
