package com.products.productsmvc.domain;

import com.products.productsmvc.domain.security.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the user domain model.
 */
@Entity
public class User extends AbstractDomainClass {
    /** The username.*/
    private String username;

    /** The user's password.*/
    @Transient
    private String password;

    /** The user's encrypted password*/
    private String encryptedPassword;

    /** Enabled flag for user.*/
    private Boolean enabled = true;

    /** The customer linked to the user*/
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Customer customer;

    /** The cart linked to the user*/
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    /** The list of roles granted to the user*/
    @ManyToMany
    @JoinTable
    // ~ defaults to @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"),
    //     inverseJoinColumns = @joinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    /**
     * Returns the username of the user as a String.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user to the value of the username parameter.
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user as a String.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user to the value of the password parameter.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the encrypted password of the user as a String.
     * @return The encrypted password of the user.
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * Sets the encrypted password of the user to the value of the encryptedPassword parameter.
     * @param encryptedPassword The encryptedPassword to set.
     */
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * Returns the enabled flag of the user as a Boolean.
     * @return The enabled flag of the user.
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled flag of the user to the value of the enabled parameter.
     * @param enabled The enabled flag to set.
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Returns the customer associated with the user as a Customer.
     * @return The customer associated with the user.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the user to the value of the customer parameter.
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.setUser(this);
    }

    /**
     * Returns the cart associated with the user as a Cart.
     * @return The cart associated with the user.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets the cart associated with the user to the value of the cart parameter.
     * @param cart The cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Returns the list of roles granted to the user.
     * @return The list of roles granted to the user.
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the list of roles to the value of the roles parameter.
     * @param roles The list of roles to set.
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Add a role to the list of roles granted to the user.
     * @param role The role to add.
     */
    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }

        if(!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }

    /**
     * Remove a role from the list of roles granted to the user.
     * @param role The role to remove.
     */
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
