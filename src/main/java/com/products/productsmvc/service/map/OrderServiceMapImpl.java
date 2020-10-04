package com.products.productsmvc.service.map;

import com.products.productsmvc.domain.DomainObject;
import com.products.productsmvc.domain.Order;
import com.products.productsmvc.service.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements the methods for handling product data.
 */
@Service
@Profile("map")
public class OrderServiceMapImpl extends MapService implements OrderService {
    /**
     * Returns a list of all the available orders.
     * @return a list of all the orders.
     */
    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    /**
     * Returns the order with a given id.
     * @param id Id of order.
     * @return The order object with the given id.
     */
    @Override
    public Order getById(Integer id) {
        return (Order) super.getById(id);
    }

    /**
     * Save or update an order.
     * @param domainObject The order that has to be saved or updated.
     * @return The saved order object.
     */
    @Override
    public Order saveOrUpdate(Order domainObject) {
        return (Order) super.saveOrUpdate(domainObject);
    }

    /**
     * Delete a order.
     * @param id Id of order.
     */
    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
