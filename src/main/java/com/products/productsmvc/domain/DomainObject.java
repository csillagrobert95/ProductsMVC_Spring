package com.products.productsmvc.domain;

/**
 * This interface defines the main methods for the domain classes.
 */
public interface DomainObject {
    /**
     * Returns the id of the domain object as an Integer.
     * @return The id of the domain object.
     */
    Integer getId();

    /**
     * Sets the id of the domain object to the value of the id parameter.
     * @param id The id to set.
     */
    void setId(Integer id);
}
