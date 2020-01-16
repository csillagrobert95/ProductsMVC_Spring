package com.products.productsmvc.service;

import com.products.productsmvc.domain.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * This class implements the methods for handling customer data.
 * It uses JPA to persist the data.
 */
@Service

@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService{
    /**
     * The EntityManagerFactory for creating EntityManager objects.
     */
    private EntityManagerFactory emf;

    /**
     * Sets the emf of the ProductService to the value of the emf parameter.
     * @param emf The EntityManagerFactory.
     */
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Returns a list of all the available customers.
     * @return a list of all the customers.
     */
    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    /**
     * Returns the customer with a given id.
     * @param id Id of customer.
     * @return The customer object with the given id.
     */
    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    /**
     * Save or update a customer.
     * @param domainObject The customer that has to be saved or updated.
     * @return The saved customer object.
     */
    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return savedCustomer;
    }

    /**
     * Delete a customer.
     * @param id Id of customer.
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
