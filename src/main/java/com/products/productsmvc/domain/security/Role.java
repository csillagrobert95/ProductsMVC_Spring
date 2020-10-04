package com.products.productsmvc.domain.security;

import com.products.productsmvc.domain.AbstractDomainClass;
import com.products.productsmvc.domain.User;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the role domain model.
 */
@Entity
public class Role extends AbstractDomainClass {
    /** The role. */
    private String role;

    /** The list of users associated with the role. */
    @ManyToMany
    @JoinTable
    // ~ defaults to @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "role_id"),
    //     inverseJoinColumns = @joinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    /**
     * Returns the role as a String.
     * @return The role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of to the value of the role parameter.
     * @param role The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the list of users associated to the role.
     * @return The list of users associated to the role.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the list of users to the value of the users parameter.
     * @param users The list of users to set.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Add a user to the list of users associated with the role.
     * @param user The user to add.
     */
    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }

    /**
     * Remove a user from the list of users associated with the role.
     * @param user The user to remove.
     */
    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
