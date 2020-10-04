package com.products.productsmvc.controller;

import com.products.productsmvc.domain.User;
import com.products.productsmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class provides the controller methods for handling requests involving users.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /** The user service which is used to handle user data.*/
    private UserService userService;

    /**
     * Sets the userService to the userService parameter.
     * @param userService The userService to set.
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * List all users.
     *
     * @param model Model object to which the users attribute is added.
     * @return user/list page name.
     */
    @RequestMapping({"/list", "/"})
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "user/list";
    }

    /**
     * Get one user by id.
     *
     * @param id Id of the user.
     * @param model Model object to which the user attribute is added.
     * @return user/show page name.
     */
    @RequestMapping("/show/{id}")
    public String getUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/show";
    }

    /**
     * Edit an existing user.
     *
     * @param id Id of the user.
     * @param model Model object to which the user attribute is added.
     * @return user/userform page name.
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user/userform";
    }

    /**
     * Add a new user.
     *
     * @param model Model object to which the new user attribute is added.
     * @return user/userform page name.
     */
    @RequestMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user/userform";
    }

    /**
     * Save or update a user.
     *
     * @param user The user that has to be saved or updated.
     * @return Redirect to the user/show page of the saved user.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveOrUpdate(User user){
        User savedUser = userService.saveOrUpdate(user);
        return "redirect:/user/show/" + savedUser.getId();
    }

    /**
     * Delete an existing user.
     *
     * @param id Id of the user.
     * @return Redirect to the user/list page.
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/user/list";
    }
}
