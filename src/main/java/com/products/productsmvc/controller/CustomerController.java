package com.products.productsmvc.controller;

import com.products.productsmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class provides the controller methods for handling requests involving customers.
 */
@Controller
public class CustomerController {
    /** The customer service which is used to handle customer data.*/
    private CustomerService customerService;

    /**
     * Sets the customerService to the customerService parameter.
     * @param customerService The customerService to set.
     */
    @Autowired
    public void setProductService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * List all customers.
     *
     * @param model Model object to which the customers attribute is added.
     * @return customers page name.
     */
    @RequestMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    /**
     * Get one customer by id.
     *
     * @param id Id of the customer.
     * @param model Model object to which the customers attribute is added.
     * @return Customer page name.
     */
    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }
}
