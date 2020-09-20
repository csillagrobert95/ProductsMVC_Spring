package com.products.productsmvc.domain;

import javax.persistence.*;

/**
 * This class represents the cart detail domain model.
 */
@Entity
public class CartDetail implements DomainObject {
    /** The id of the cartDetail. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The version of the cartDetail. */
    @Version
    private Integer version;

    /** The cart of the cartDetail. */
    @ManyToOne
    private Cart cart;

    /** The product of the cartDetail. */
    @OneToOne
    private Product product;

    /**
     * Returns the id of the cartDetail as an Integer.
     * @return The id of the cartDetail.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the cartDetail to the value of the id parameter.
     * @param id The id to set.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the version of the cartDetail as an Integer.
     * @return The version of the cartDetail.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the cartDetail to the value of the version parameter.
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

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
}
