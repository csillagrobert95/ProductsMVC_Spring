package com.products.productsmvc.service.jpa;

import com.products.productsmvc.domain.Product;
import com.products.productsmvc.service.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements the methods for handling product data.
 * It uses JPA to persist the data.
 */
@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl extends JpaDaoService implements ProductService {
    /**
     * Returns a list of all the available products.
     * @return a list of all the products.
     */
    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    /**
     * Returns the product with a given id.
     * @param id Id of product.
     * @return The product object with the given id.
     */
    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    /**
     * Save or update a product.
     * @param domainObject The product that has to be saved or updated.
     * @return The saved product object.
     */
    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return savedProduct;
    }

    /**
     * Delete a product.
     * @param id Id of product.
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
