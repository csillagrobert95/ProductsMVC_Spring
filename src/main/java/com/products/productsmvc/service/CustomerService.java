package com.products.productsmvc.service;

import com.products.productsmvc.domain.Customer;

import java.util.List;

/**
 * This interface defines the methods for handling customer data.
 */
public interface CustomerService {
    /**
     * Returns a list of all the available customers.
     * @return a list of all the customers.
     */
    List<Customer> listAllCustomers();

    /**
     * Returns the customer with a given id.
     * @param id Id of customer.
     * @return The customer object with the given id.
     */
    Customer getCustomerById(Integer id);

    /**
     * Save or update a customer.
     * @param customer The customer that has to be saved or updated.
     * @return The saved customer object.
     */
    Customer saveOrUpdateCustomer(Customer customer);

    /**
     * Delete a customer.
     * @param id Id of customer.
     */
    void deleteCustomer(Integer id);
}
