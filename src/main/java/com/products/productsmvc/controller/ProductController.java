package com.products.productsmvc.controller;

import com.products.productsmvc.domain.Product;
import com.products.productsmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * List all products
     *
     * @param model Model object to which the products attribute is added
     * @return products page name
     */
    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    /**
     * Get one product by id
     *
     * @param id Id of the product
     * @param model Model object to which the products attribute is added
     * @return Product page name
     */
    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    /**
     * Add a new product
     *
     * @param model Model object to which the new product attribute is added
     * @return Productform page name
     */
    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Save or update a product
     *
     * @param product The product that has to be saved or updated
     * @return Redirect to the product page of the saved product
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/" + savedProduct.getId();
    }

    /**
     * Edit an existing product
     *
     * @param id Id of the product
     * @param model Model object to which the product attribute is added
     * @return Productform page name
     */
    @RequestMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }
}
