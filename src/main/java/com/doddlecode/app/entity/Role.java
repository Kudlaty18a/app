package com.doddlecode.app.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @ManyToMany
    @JoinTable(name = "user_has_role",
            catalog = "login",
            schema = "public",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false))
    private Set<UserAccount> users;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, name);
    }

    public Set<UserAccount> getUsers() {
        return users;
    }

    public void setUsers(Set<UserAccount> users) {
        this.users = users;
    }
}
