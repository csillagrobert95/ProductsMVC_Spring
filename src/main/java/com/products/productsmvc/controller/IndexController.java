package com.products.productsmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * Returns the index page
     *
     * @return index page name
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
