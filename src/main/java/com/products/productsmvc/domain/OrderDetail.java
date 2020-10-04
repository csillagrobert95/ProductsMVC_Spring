package com.products.productsmvc.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * This class represents the order detail domain model.
 */
@Entity
public class OrderDetail extends AbstractDomainClass {
    /** The order associated with the order detail.*/
    @ManyToOne
    private Order order;

    /** The product contained in the order detail.*/
    @OneToOne
    private Product product;

    /** The product quantity.*/
    private Integer quantity;

    /**
     * Returns the order associated with the order detail as an Order.
     * @return The order associated with the order detail.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the order detail to the value of the order parameter.
     * @param order The order to set.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Returns the product contained in the order detail as a Product.
     * @return The product contained in the order detail.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product contained in the order detail to the value of the product parameter.
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the quantity of the product in the order detail as an Integer.
     * @return The quantity of the product in the order detail.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the order detail to the value of the quantity parameter.
     * @param quantity The quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
