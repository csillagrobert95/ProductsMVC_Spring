package com.products.productsmvc.service.jpa;

import com.products.productsmvc.domain.Customer;
import com.products.productsmvc.service.CustomerService;
import com.products.productsmvc.service.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements the methods for handling customer data.
 * It uses JPA to persist the data.
 */
@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl extends JpaDaoService implements CustomerService {
    /**
     * Encryption service.
     */
    private EncryptionService encryptionService;

    /**
     * Sets the encryptionService the value of the encryptionService parameter.
     * @param encryptionService The EncryptionService to set.
     */
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
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

        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(
                    encryptionService.encryptString(domainObject.getUser().getPassword()));
        }

        Customer savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();

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
