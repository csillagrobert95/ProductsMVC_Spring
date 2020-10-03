package com.products.productsmvc.controller;

import com.products.productsmvc.domain.Address;
import com.products.productsmvc.domain.Customer;
import com.products.productsmvc.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test the CustomerController class.
 */
public class CustomerControllerTest {
    /**
     * CustomerService Mock instance.
     */
    @Mock //Mockito Mock object
    private CustomerService customerService;

    /**
     * CustomerController with injected mock objects.
     */
    @InjectMocks //Sets up controller, and injects mock objects into it.
    private CustomerController customerController;

    /**
     * The MockMvc instance.
     */
    private MockMvc mockMvc;

    /**
     * Sets up the required instances for testing.
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //initializes controller and mocks
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    /**
     * Tests the listCustomers method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testListCustomers() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        //specific Mockito interaction, tell stub to return list of products
        when(customerService.listAll()).thenReturn((List) customers); //need to strip generics to keep Mockito happy.

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/list"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    /**
     * Tests the showCustomer method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testShowCustomer() throws Exception {
        Integer id = 1;

        //Tell Mockito stub to return new product for ID 1
        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/show"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    /**
     * Tests the editCustomer method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testEditCustomer() throws Exception {
        Integer id = 1;

        //Tell Mockito stub to return new product for ID 1
        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    /**
     * Tests the newCustomer method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testNewCustomer() throws Exception {
        //should not call service
        verifyZeroInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    /**
     * Tests the saveOrUpdateCustomer method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testSaveOrUpdateCustomer() throws Exception {
        Integer id = 1;
        Customer returnCustomer = new Customer();
        String firstName = "Micheal";
        String lastName = "Weston";
        String addressLine1 = "1 Main St";
        String addressLine2 = "Apt 301";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "micheal@burnnotice.com";
        String phoneNumber = "305.333.0101";

        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setBillingAddress(new Address());
        returnCustomer.getBillingAddress().setAddressLine1(addressLine1);
        returnCustomer.getBillingAddress().setAddressLine2(addressLine2);
        returnCustomer.getBillingAddress().setCity(city);
        returnCustomer.getBillingAddress().setState(state);
        returnCustomer.getBillingAddress().setZipCode(zipCode);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(any())).thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
                .param("id", "1")
                .param("firstName", firstName)
                .param("lastName", lastName)
                .param("shippingAddress.addressLine1", addressLine1)
                .param("shippingAddress.addressLine2", addressLine2)
                .param("shippingAddress.city", city)
                .param("shippingAddress.state", state)
                .param("shippingAddress.zipCode", zipCode)
                .param("email", email)
                .param("phoneNumber", phoneNumber))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLine1", is(addressLine1)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLine2", is(addressLine2)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("city", is(city)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("state", is(state)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("zipCode", is(zipCode)))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();

        assertEquals(id, boundCustomer.getId());
        assertEquals(firstName, boundCustomer.getFirstName());
        assertEquals(lastName, boundCustomer.getLastName());
        assertEquals(addressLine1, boundCustomer.getShippingAddress().getAddressLine1());
        assertEquals(addressLine2, boundCustomer.getShippingAddress().getAddressLine2());
        assertEquals(city, boundCustomer.getShippingAddress().getCity());
        assertEquals(state, boundCustomer.getShippingAddress().getState());
        assertEquals(zipCode, boundCustomer.getShippingAddress().getZipCode());
        assertEquals(email, boundCustomer.getEmail());
        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());
    }

    /**
     * Tests the deleteCustomer method.
     *
     * @throws Exception The exception which can be thrown.
     */
    @Test
    public void testDeleteCustomer() throws Exception {
        Integer id = 1;

        mockMvc.perform(get("/customer/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/list"));

        verify(customerService, times(1)).delete(id);
    }
}
