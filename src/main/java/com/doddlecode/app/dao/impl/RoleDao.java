package com.doddlecode.app.dao.impl;

import com.doddlecode.app.dao.AbstractDao;
import com.doddlecode.app.dao.IRoleDao;
import com.doddlecode.app.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends AbstractDao<Role> implements IRoleDao {

    @Override
    public Role findByName(String name) {
        return (Role) getCurrentSession().createQuery("SELECT r FROM Role r WHERE r.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }

}
