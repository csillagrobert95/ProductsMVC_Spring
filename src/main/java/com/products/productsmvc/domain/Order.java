package com.products.productsmvc.domain;

import com.products.productsmvc.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents the order domain model.
 */
@Entity
@Table(name = "ORDER_HEADER")
public class Order extends AbstractDomainClass {
    /** The customer linked to the order.*/
    @OneToOne
    private Customer customer;

    /** The shipping address of the order.*/
    @Embedded
    private Address shipToAddress;

    /** The order details linked to the order.*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    /** The order status.*/
    private OrderStatus orderStatus;

    /** The date the order was shipped.*/
    private Date dateShipped;

    /**
     * Returns the customer associated with the order as a Customer.
     * @return The customer associated with the order.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the order to the value of the customer parameter.
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns the shipping address of the order as an Address.
     * @return The shipping address of the order.
     */
    public Address getShipToAddress() {
        return shipToAddress;
    }

    /**
     * Sets the shipping address of the order to the value of the shipToAddress parameter.
     * @param shipToAddress The shipping address to set.
     */
    public void setShipToAddress(Address shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    /**
     * Returns the list of order details as a List.
     * @return The list of order details.
     */
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * Sets the list of order details to the value of the orderDetails parameter.
     * @param orderDetails The list of order details to set.
     */
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * Add an OrderDetail to the list of order details.
     * @param orderDetail The OrderDetail to add.
     */
    public void addToOrderDetails(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }

    /**
     * Remove an OrderDetail from the list of order details.
     * @param orderDetail The OrderDetail to remove.
     */
    public void removeOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(null);
        orderDetails.remove(orderDetail);
    }

    /**
     * Returns the status of the order as an OrderStatus.
     * @return The status of the order.
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the status of the order to the value of the orderStatus parameter.
     * @param orderStatus The status of the order to set.
     */
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Returns the shipping date of the order as a Date.
     * @return The shipping date of the order.
     */
    public Date getDateShipped() {
        return dateShipped;
    }

    /**
     * Sets the shipping date of the order to the value of the dateShipped parameter.
     * @param dateShipped The shipping date of the order to set.
     */
    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }
}
