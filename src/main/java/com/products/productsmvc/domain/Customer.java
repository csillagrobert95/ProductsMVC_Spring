package com.products.productsmvc.domain;

import javax.persistence.*;

/**
 * This class represents the customer domain model.
 */
@Entity
public class Customer implements DomainObject{
    /** The id of the customer. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The version used for persistence */
    @Version
    private Integer version;

    /** The first name of the customer. */
    private String firstName;

    /** The last name of the customer. */
    private String lastName;

    /** The email address of the customer. */
    private String email;

    /** The phone number of the customer. */
    private String phoneNumber;

    /** The billing address of the customer. */
    @Embedded
    private Address billingAddress;

    /** The shipping address of the customer. */
    @Embedded
    private Address shippingAddress;

    /** The user entity linked to the customer. */
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

    /**
     * Returns the id of the customer as an Integer.
     * @return The id of the customer.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the customer to the value of the id parameter.
     * @param id The id to set.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the version of the product as an Integer.
     * @return The version of the product.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the product to the value of the version parameter.
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Returns the firstName of the customer as a String.
     * @return The firstName of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName of the customer to the value of the firstName parameter.
     * @param firstName The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastName of the customer as a String.
     * @return The lastName of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName of the customer to the value of the lastName parameter.
     * @param lastName The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email of the customer as a String.
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer to the value of the email parameter.
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phoneNumber of the customer as a String.
     * @return The phoneNumber of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phoneNumber of the customer to the value of the phoneNumber parameter.
     * @param phoneNumber The phoneNumber to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the billingAddress of the customer as an Address.
     * @return The billingAddress of the customer.
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the billingAddress of the customer to the value of the billingAddress parameter.
     * @param billingAddress The billingAddress to set.
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Returns the shippingAddress of the customer as an Address.
     * @return The shippingAddress of the customer.
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shippingAddress of the customer to the value of the shippingAddress parameter.
     * @param shippingAddress The shippingAddress to set.
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Returns the user of the customer as a User.
     * @return The user of the customer.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of the customer to the value of the user parameter.
     * @param user The User to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

}
