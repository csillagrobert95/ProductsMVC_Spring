package com.products.productsmvc.service.jpa;

import com.products.productsmvc.domain.User;
import com.products.productsmvc.service.UserService;
import com.products.productsmvc.service.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements the methods for handling user data.
 * It uses JPA to persist the data.
 */
@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends JpaDaoService implements UserService {
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
     * Returns a list of all the available users.
     * @return a list of all the users.
     */
    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from User", User.class).getResultList();
    }

    /**
     * Returns the user with a given id.
     * @param id Id of user.
     * @return The user object with the given id.
     */
    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(User.class, id);
    }

    /**
     * Save or update a user.
     * @param domainObject The user that has to be saved or updated.
     * @return The saved user object.
     */
    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }

        User savedUser = em.merge(domainObject);
        em.getTransaction().commit();

        return savedUser;
    }

    /**
     * Delete a user.
     * @param id Id of the user which has to be deleted.
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
