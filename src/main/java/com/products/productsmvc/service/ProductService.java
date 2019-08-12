package com.products.productsmvc.service;

import com.products.productsmvc.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * Returns a list of all the available products
     *
     * @return a list of all the products
     */
    List<Product> listAllProducts();


    /**
     * Returns the product with a given id
     *
     * @param id Id of product
     * @return The product object with the given id
     */
    Product getProductById(Integer id);

    /**
     * Save or update a product
     *
     * @param product The product that has to be saved or updated
     * @return The saved product object
     */
    Product saveOrUpdateProduct(Product product);
}
