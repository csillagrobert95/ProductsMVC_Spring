package com.products.productsmvc.service;

import com.products.productsmvc.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test the CustomerServiceJpaDaoImpl class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest {
    /**
     * The customerService.
     */
    private CustomerService customerService;

    /**
     * Sets the customerService to the value of the customerService parameter.
     * @param customerService The customerService to set.
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Test the listAll method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testListAll() throws Exception{
        List<Customer> customers = (List<Customer>)customerService.listAll();

        assertEquals(3, customers.size());
    }

    /**
     * Test the getById method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testGetById() throws Exception{
        int id = 6;
        Customer customer = customerService.getById(id);
        assertNotNull(customer);
        assertEquals(id, customer.getId().intValue());
    }

    /**
     * Test the saveOrUpdate method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testSaveOrUpdate() throws Exception{
        Customer customer = new Customer();
        customer.setFirstName("Micheal");
        customer.setLastName("Weston");
        customer.setAddressLineOne("1 Main St");
        customer.setCity("Miami");
        customer.setState("Florida");
        customer.setZipCode("33101");
        customer.setEmail("micheal@burnnotice.com");
        customer.setPhoneNumber("305.333.0101");

        Customer savedCustomer = customerService.saveOrUpdate(customer);
        assertNotNull(savedCustomer);
        assertEquals(customer.getFirstName(), savedCustomer.getFirstName());
        assertEquals(customer.getLastName(), savedCustomer.getLastName());
        assertEquals(customer.getAddressLineOne(), savedCustomer.getAddressLineOne());
        assertEquals(customer.getCity(), savedCustomer.getCity());
        assertEquals(customer.getState(), savedCustomer.getState());
        assertEquals(customer.getZipCode(), savedCustomer.getZipCode());
        assertEquals(customer.getEmail(), savedCustomer.getEmail());
        assertEquals(customer.getPhoneNumber(), savedCustomer.getPhoneNumber());
    }

    /**
     * Test the delete method.
     * @throws Exception The thrown exception.
     */
    @Test
    public void testDelete() throws Exception{
        List<Customer> customers = (List<Customer>)customerService.listAll();

        customerService.delete(customers.get(0).getId());

        List<Customer> customersAfterDel = (List<Customer>)customerService.listAll();

        assertEquals(customers.size() - 1, customersAfterDel.size());
    }
}
