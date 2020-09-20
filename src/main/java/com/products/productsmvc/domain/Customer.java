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

    /** The first line of the customer's address. */
    private String addressLineOne;

    /** The second line of the customer's address. */
    private String addressLineTwo;

    /** The customer's city. */
    private String city;

    /** The customer's state. */
    private String state;

    /** The customer's zip code. */
    private String zipCode;

    /** The user instance linked to the customer. */
    @OneToOne(cascade = {CascadeType.ALL})
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
     * Returns the addressLineOne of the customer as a String.
     * @return The addressLineOne of the customer.
     */
    public String getAddressLineOne() {
        return addressLineOne;
    }

    /**
     * Sets the addressLineOne of the customer to the value of the addressLineOne parameter.
     * @param addressLineOne The addressLineOne to set.
     */
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    /**
     * Returns the addressLineTwo of the customer as a String.
     * @return The addressLineTwo of the customer.
     */
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    /**
     * Sets the addressLineTwo of the customer to the value of the addressLineTwo parameter.
     * @param addressLineTwo The addressLineTwo to set.
     */
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    /**
     * Returns the city of the customer as a String.
     * @return The city of the customer.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the customer to the value of the city parameter.
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state of the customer as a String.
     * @return The state of the customer.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the customer to the value of the state parameter.
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zipCode of the customer as a String.
     * @return The zipCode of the customer.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zipCode of the customer to the value of the zipCode parameter.
     * @param zipCode The zipCode to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressLineOne='" + addressLineOne + '\'' +
                ", addressLineTwo='" + addressLineTwo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", user=" + user +
                '}';
    }
}
