package com.products.productsmvc.service;

import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * This class implements the methods for handling product data.
 */
@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService {
    /**
     * Returns a list of all the available products.
     * @return a list of all the products.
     */
    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    /**
     * Returns the product with a given id.
     * @param id Id of product.
     * @return The product object with the given id.
     */
    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    /**
     * Save or update a product.
     * @param domainObject The product that has to be saved or updated.
     * @return The saved product object.
     */
    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    /**
     * Delete a product.
     * @param id Id of product.
     */
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    /**
     * Load the products into a HashMap.
     */
    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        domainMap.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        domainMap.put(2, product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        domainMap.put(3, product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        domainMap.put(4, product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        domainMap.put(5, product5);
    }
}
