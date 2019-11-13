package com.products.productsmvc.service;

import java.util.List;

/**
 * This interface defines the methods for handling domain object data.
 */
public interface CRUDService<T> {
    /**
     * Returns a list of the available domain objects.
     * @return a list of all the domain objects.
     */
    List<?> listAll();

    /**
     * Returns the domain object with a given id.
     * @param id Id of domain object.
     * @return The domain object with the given id.
     */
    T getById(Integer id);

    /**
     * Save or update a domain object.
     * @param domainObject The domain object that has to be saved or updated.
     * @return The saved domain object.
     */
    T saveOrUpdate(T domainObject);

    /**
     * Delete a domain object.
     * @param id Id of domain object.
     */
    void delete(Integer id);
}
