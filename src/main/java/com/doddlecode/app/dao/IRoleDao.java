package com.doddlecode.app.dao;

import com.doddlecode.app.entity.Role;

public interface IRoleDao {
    Role findByName(String name);
}
