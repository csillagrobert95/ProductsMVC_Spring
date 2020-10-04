package com.products.productsmvc.service.jpa;

import com.products.productsmvc.domain.Order;
import com.products.productsmvc.service.OrderService;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This class implements the methods for handling order data.
 * It uses JPA to persist the data.
 */
public class OrderServiceJpaDaoImpl extends JpaDaoService implements OrderService {
    /**
     * Returns a list of all the available orders.
     * @return a list of all the orders.
     */
    @Override
    public List<Order> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Order", Order.class).getResultList();
    }

    /**
     * Returns the order with a given id.
     * @param id Id of order.
     * @return The order object with the given id.
     */
    @Override
    public Order getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Order.class, id);
    }

    /**
     * Save or update an order.
     * @param domainObject The order that has to be saved or updated.
     * @return The saved order object.
     */
    @Override
    public Order saveOrUpdate(Order domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Order savedProduct = em.merge(domainObject);
        em.getTransaction().commit();

        return savedProduct;
    }

    /**
     * Delete a order.
     * @param id Id of order.
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Order.class, id));
        em.getTransaction().commit();
    }
}
