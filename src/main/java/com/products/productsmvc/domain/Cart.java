package com.products.productsmvc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cart domain model.
 */
@Entity
public class Cart implements DomainObject {
    /** The id of the cart. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The version of the cart. */
    @Version
    private Integer version;

    /** The user linked to the cart. */
    @OneToOne
    private User user;

    /** The list of cart details. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();

    /**
     * Returns the id of the cart as an Integer.
     * @return The id of the cart.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the cart to the value of the id parameter.
     * @param id The id to set.
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the version of the cart as an Integer.
     * @return The version of the cart.
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version of the cart to the value of the version parameter.
     * @param version The version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Returns the user linked to the cart as a User.
     * @return The user linked to the cart.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user linked to the cart to the value of the user parameter.
     * @param user The User to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the list of cart details.
     * @return The list of cart details.
     */
    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    /**
     * Sets the list of cart details to the value of the cartDetails parameter.
     * @param cartDetails The cartDetails to set.
     */
    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    /**
     * Adds the cartDetail to the list of cart details.
     * @param cartDetail The cartDetail to add.
     */
    public void addCartDetail(CartDetail cartDetail){
        cartDetails.add(cartDetail);
        cartDetail.setCart(this);
    }

    /**
     * Remove the cartDetail from the list of cart details.
     * @param cartDetail The cartDetail to remove.
     */
    public void removeCartDetail(CartDetail cartDetail){
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }
}
