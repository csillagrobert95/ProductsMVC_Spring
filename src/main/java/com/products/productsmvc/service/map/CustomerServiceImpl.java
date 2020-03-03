package com.products.productsmvc.service.map;

import com.products.productsmvc.domain.Customer;
import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.service.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class implements the methods for handling product data.
 */
@Service
@Profile("map")
public class CustomerServiceImpl extends MapService implements CustomerService {
    /**
     * Returns a list of all the available customers.
     * @return a list of all the customers.
     */
    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    /**
     * Returns the customer with a given id.
     * @param id Id of customer.
     * @return The customer object with the given id.
     */
    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    /**
     * Save or update a customer.
     * @param domainObject The customer that has to be saved or updated.
     * @return The saved customer object.
     */
    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    /**
     * Delete a customer.
     * @param id Id of customer.
     */
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
