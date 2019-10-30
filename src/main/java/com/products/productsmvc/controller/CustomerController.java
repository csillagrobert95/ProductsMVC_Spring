package com.products.productsmvc.controller;

import com.products.productsmvc.domain.Customer;
import com.products.productsmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * Add a new customer.
     *
     * @param model Model object to which the new customer attribute is added.
     * @return Customerform page name.
     */
    @RequestMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    /**
     * Save or update a customer.
     *
     * @param customer The customer that has to be saved or updated.
     * @return Redirect to the customer page of the saved product.
     */
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/" + savedCustomer.getId();
    }
}
