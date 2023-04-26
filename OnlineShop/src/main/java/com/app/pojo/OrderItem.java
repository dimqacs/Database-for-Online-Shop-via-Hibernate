package com.app.pojo;

import jakarta.persistence.*;

@Entity(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INTEGER")
    private int OrderItemId;

    @Column(name = "Count", columnDefinition = "INTEGER")
    private int OrderItemCount;

    @Column(name = "TotalPrice", columnDefinition = "FLOAT")
    private float OrderItemTotalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order Order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product Product;

    public int getOrderItemId() {
        return OrderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        OrderItemId = orderItemId;
    }

    public int getOrderItemCount() {
        return OrderItemCount;
    }

    public void setOrderItemCount(int orderItemCount) {
        OrderItemCount = orderItemCount;
    }

    public float getOrderItemTotalPrice() {
        return OrderItemTotalPrice;
    }

    public void setOrderItemTotalPrice(float orderItemTotalPrice) {
        OrderItemTotalPrice = orderItemTotalPrice;
    }

    public com.app.pojo.Order getOrder() {
        return Order;
    }

    public void setOrder(com.app.pojo.Order order) {
        Order = order;
    }

    public com.app.pojo.Product getProduct() {
        return Product;
    }

    public void setProduct(com.app.pojo.Product product) {
        Product = product;
    }

    public float TotalPrice()
    {
        int count = this.getOrderItemCount();
        float price = this.getProduct().getProductPrice();
        return price * count;
    }

}
