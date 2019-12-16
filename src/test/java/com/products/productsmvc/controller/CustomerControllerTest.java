package com.products.productsmvc.controller;

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
        String firstName = "Michael";
        String lastName = "Weston";
        String addressLineOne = "Main st";
        String addressLineTwo = "nr. 1";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "micheal@burnnotice.com";
        String phoneNumber = "305.333.0101";

        Customer returnCustomer = new Customer();
        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setAddressLineOne(addressLineOne);
        returnCustomer.setCity(city);
        returnCustomer.setState(state);
        returnCustomer.setZipCode(zipCode);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(any())).thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
                .param("id", "1")
                .param("firstName", "Michael")
                .param("lastName", "Weston")
                .param("addressLineOne", "Main st")
                .param("addressLineTwo", "nr. 1")
                .param("city", "Miami")
                .param("state", "Florida")
                .param("zipCode", "33101")
                .param("email", "micheal@burnnotice.com")
                .param("phoneNumber", "305.333.0101"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("id", is(id))))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("addressLineOne", is(addressLineOne))))
                .andExpect(model().attribute("customer", hasProperty("addressLineTwo", is(addressLineTwo))))
                .andExpect(model().attribute("customer", hasProperty("city", is(city))))
                .andExpect(model().attribute("customer", hasProperty("state", is(state))))
                .andExpect(model().attribute("customer", hasProperty("zipCode", is(zipCode))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        //verify properties of bound object
        ArgumentCaptor<Customer> boundCustomer = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(boundCustomer.capture());

        assertEquals(id, boundCustomer.getValue().getId());
        assertEquals(firstName, boundCustomer.getValue().getFirstName());
        assertEquals(lastName, boundCustomer.getValue().getLastName());
        assertEquals(addressLineOne, boundCustomer.getValue().getAddressLineOne());
        assertEquals(addressLineTwo, boundCustomer.getValue().getAddressLineTwo());
        assertEquals(city, boundCustomer.getValue().getCity());
        assertEquals(state, boundCustomer.getValue().getState());
        assertEquals(zipCode, boundCustomer.getValue().getZipCode());
        assertEquals(email, boundCustomer.getValue().getEmail());
        assertEquals(phoneNumber, boundCustomer.getValue().getPhoneNumber());
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
