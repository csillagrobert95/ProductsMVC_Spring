package com.products.productsmvc.service.jpa;

import com.products.productsmvc.domain.security.Role;
import com.products.productsmvc.service.RoleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements the methods for handling role data.
 */
@Service
@Profile("jpadao")
public class RoleServiceJpaImpl extends JpaDaoService implements RoleService {
    /**
     * Returns a list of all the available roles.
     * @return a list of all the roles.
     */
    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Role", Role.class).getResultList();
    }

    /**
     * Returns the role with a given id.
     * @param id Id of role.
     * @return The role object with the given id.
     */
    @Override
    public Role getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Role.class, id);
    }

    /**
     * Save or update a role.
     * @param domainObject The role that has to be saved or updated.
     * @return The saved role object.
     */
    @Override
    public Role saveOrUpdate(Role domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Role saveRole = em.merge(domainObject);
        em.getTransaction().commit();

        return saveRole;
    }

    /**
     * Delete a role.
     * @param id Id of role.
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Role.class, id));
        em.getTransaction().commit();
    }
}
