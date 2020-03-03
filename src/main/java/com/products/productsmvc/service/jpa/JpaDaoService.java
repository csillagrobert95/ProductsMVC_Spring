package com.products.productsmvc.service.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Base class for JPA DAO Service implementations.
 */
public class JpaDaoService {
    /**
     * The EntityManagerFactory for creating EntityManager objects.
     */
    protected EntityManagerFactory emf;

    /**
     * Sets the emf of the ProductService to the value of the emf parameter.
     * @param emf The EntityManagerFactory.
     */
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
