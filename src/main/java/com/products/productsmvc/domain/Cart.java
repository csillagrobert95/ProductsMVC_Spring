package com.products.productsmvc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cart domain model.
 */
@Entity
public class Cart extends AbstractDomainClass {
    /** The user linked to the cart. */
    @OneToOne
    private User user;

    /** The list of cart details. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartDetail> cartDetails = new ArrayList<>();

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
