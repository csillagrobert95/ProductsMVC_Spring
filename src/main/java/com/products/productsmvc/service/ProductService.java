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
}
