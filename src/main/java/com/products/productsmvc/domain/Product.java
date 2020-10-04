package com.products.productsmvc.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * This class represents the product domain model.
 */
@Entity
public class Product extends AbstractDomainClass{
    /** The description of the product.*/
    private String description;

    /** The price of the product.*/
    private BigDecimal price;

    /** The URL of the product image.*/
    private String imageUrl;

    /**
     * Returns the description of the product as a String.
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product to the value of the description parameter.
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the price of the product as a BigDecimal.
     * @return The price of the product.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product to the value of the price parameter.
     * @param price The price to set.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns the image URL of the product as a String.
     * @return The image URL of the product.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the image URL of the product to the value of the imageUrl parameter.
     * @param imageUrl The image URL to set.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
