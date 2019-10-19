package com.products.productsmvc.service;

import com.products.productsmvc.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class implements the methods for handling product data.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    /**
     * The Map which stores the products.
     */
    private Map<Integer,Customer> customers;

    /**
     * Public Constructor.
     */
    public CustomerServiceImpl(){
        loadCustomers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null){
            if (customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
            return customer;
        } else {
            throw new RuntimeException("Customer Can't be null");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    /**
     * Load the customers into a HashMap.
     */
    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Bill");
        customer1.setLastName("Gates");
        customer1.setEmail("bill.gates@microsoft.com");
        customer1.setPhoneNumber("0743.999.567");
        customer1.setAddressLineOne("Microsoft Ave.");
        customer1.setAddressLineTwo("Nr. 1");
        customer1.setCity("Los Angeles");
        customer1.setState("California");
        customer1.setZipCode("410001");
        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Jeff");
        customer2.setLastName("Bezos");
        customer2.setEmail("jeff.bezos@amazon.com");
        customer2.setPhoneNumber("0743.999.568");
        customer2.setAddressLineOne("Amazon Ave.");
        customer2.setAddressLineTwo("Nr. 2");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setZipCode("410002");
        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Warren");
        customer3.setLastName("Buffett");
        customer3.setEmail("warren.buffett@berkshire.com");
        customer3.setPhoneNumber("0743.999.569");
        customer3.setAddressLineOne("berkshire Ave.");
        customer3.setAddressLineTwo("Nr. 3");
        customer3.setCity("Los Angeles");
        customer3.setState("California");
        customer3.setZipCode("410003");
        customers.put(3, customer3);
    }

    /**
     * Calculates the next key in the keySet. Increments the last one by 1.
     * @return The next key in the keySet
     */
    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }
}
