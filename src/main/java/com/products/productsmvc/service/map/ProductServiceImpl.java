package com.products.productsmvc.service.map;

import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.domain.Product;
import com.products.productsmvc.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class implements the methods for handling product data.
 */
@Service
@Profile("map")
public class ProductServiceImpl extends MapService implements ProductService {
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
}
