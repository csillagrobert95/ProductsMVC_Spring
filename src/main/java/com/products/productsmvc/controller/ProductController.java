package com.products.productsmvc.controller;

import com.products.productsmvc.domain.Product;
import com.products.productsmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class provides the controller methods for handling requests involving products.
 */
@RequestMapping("/product")
@Controller
public class ProductController {
    /** The product service which is used to handle product data.*/
    private ProductService productService;

    /**
     * Sets the productService to the productService parameter.
     *
     * @param productService The productService to set.
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * List all products.
     *
     * @param model Model object to which the products attribute is added.
     * @return product/list page name.
     */
    @RequestMapping({"/list", "/"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    /**
     * Get one product by id.
     *
     * @param id Id of the product.
     * @param model Model object to which the products attribute is added.
     * @return product/show page name.
     */
    @RequestMapping("/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    /**
     * Add a new product.
     *
     * @param model Model object to which the new product attribute is added.
     * @return product/productform page name.
     */
    @RequestMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    /**
     * Save or update a product.
     *
     * @param product The product that has to be saved or updated.
     * @return Redirect to the product/show page of the saved product.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product newProduct = productService.saveOrUpdate(product);
        return "redirect:product/show/" + newProduct.getId();
    }

    /**
     * Edit an existing product.
     *
     * @param id Id of the product.
     * @param model Model object to which the product attribute is added.
     * @return product/productform page name.
     */
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/productform";
    }

    /**
     * Delete an existing product.
     *
     * @param id Id of the product.
     * @return Redirect to the products page.
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}
