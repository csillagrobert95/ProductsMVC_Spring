package com.products.productsmvc.domain;

import javax.persistence.*;

/**
 * This class represents the cart detail domain model.
 */
@Entity
public class CartDetail extends AbstractDomainClass {
    /** The cart of the cartDetail. */
    @ManyToOne
    private Cart cart;

    /** The product of the cartDetail. */
    @OneToOne
    private Product product;

    /** The quantity of the cartDetail. */
    private Integer quantity;

    /**
     * Returns the cart of the cartDetail as a Cart.
     * @return The cart of the cartDetail.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets the cart of the cartDetail to the value of the cart parameter.
     * @param cart The cart to set.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Returns the product of the cartDetail as a Product.
     * @return The product of the cartDetail.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product of the cartDetail to the value of the product parameter.
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the quantity of the cartDetail as an Integer.
     * @return The product of the cartDetail.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the cartDetail to the value of the quantity parameter.
     * @param quantity The quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
