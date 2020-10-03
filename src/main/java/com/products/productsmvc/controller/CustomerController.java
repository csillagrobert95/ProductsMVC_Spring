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
@RequestMapping("/customer")
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
     * @return customers/list page name.
     */
    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    /**
     * Get one customer by id.
     *
     * @param id Id of the customer.
     * @param model Model object to which the customers attribute is added.
     * @return customer/show page name.
     */
    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    /**
     * Add a new customer.
     *
     * @param model Model object to which the new customer attribute is added.
     * @return customer/customerform page name.
     */
    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    /**
     * Save or update a customer.
     *
     * @param customer The customer that has to be saved or updated.
     * @return Redirect to the customer/show page of the saved customer.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer newCustomer = customerService.saveOrUpdate(customer);
        return "redirect:customer/show/" + newCustomer.getId();
    }

    /**
     * Edit an existing customer.
     *
     * @param id Id of the customer.
     * @param model Model object to which the customer attribute is added.
     * @return customer/customerform page name.
     */
    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform";
    }

    /**
     * Delete an existing customer.
     *
     * @param id Id of the customer.
     * @return Redirect to the customer/list page.
     */
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
