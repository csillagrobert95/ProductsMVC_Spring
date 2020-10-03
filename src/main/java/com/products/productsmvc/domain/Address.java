package com.products.productsmvc.domain;

import javax.persistence.Embeddable;

/**
 * This class represents the address domain model.
 */
@Embeddable
public class Address {
    /** The first line of the address. */
    private String addressLine1;

    /** The second line of the address. */
    private String addressLine2;

    /** The city. */
    private String city;

    /** The state. */
    private String state;

    /** The zip code. */
    private String zipCode;

    /**
     * Returns the addressLine1 of the address as a String.
     * @return The addressLine1 of the address.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the addressLine1 of the address to the value of the addressLine1 parameter.
     * @param addressLine1 The addressLine1 to set.
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Returns the addressLine2 of the customer as a String.
     * @return The addressLine2 of the customer.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the addressLine2 of the address to the value of the addressLine2 parameter.
     * @param addressLine2 The addressLine2 to set.
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Returns the city of the address as a String.
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address to the value of the city parameter.
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state of the address as a String.
     * @return The state of the address.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the address to the value of the state parameter.
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zipCode of the address as a String.
     * @return The zipCode of the address.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zipCode of the address to the value of the zipCode parameter.
     * @param zipCode The zipCode to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
