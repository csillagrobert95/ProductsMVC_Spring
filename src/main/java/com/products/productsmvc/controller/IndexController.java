package com.products.productsmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class provides the controller methods for handling requests involving the index page.
 */
@Controller
public class IndexController {
    /**
     * Returns the index page.
     *
     * @return index page name.
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
