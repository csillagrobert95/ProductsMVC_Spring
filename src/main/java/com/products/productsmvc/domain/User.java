package com.products.productsmvc.domain;

import javax.persistence.*;

/**
 * This class represents the user domain model.
 */
@Entity
public class User implements DomainObject {
    /** The id of the user.*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The version used for persistence */
    @Version
    private Integer version;

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

    /**
     * Returns the id of the user as an Integer.
     * @return The id of the user.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the user to the value of the id parameter.
     * @param id The id to set.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the version of the user as an Integer.
     * @return The version of the user.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the user to the value of the version parameter.
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

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
}
