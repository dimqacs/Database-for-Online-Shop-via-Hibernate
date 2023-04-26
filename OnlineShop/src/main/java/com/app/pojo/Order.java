package com.app.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Orderr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INTEGER")
    private int OrderId;

    @Column(name = "Status", columnDefinition = "VARCHAR(20)")
    private String OrderStatus;

    @Column(name = "Total", columnDefinition = "INTEGER")
    private float OrderTotalPrice;

    @Column(name = "Created", columnDefinition = "DATE")
    private LocalDate OrderCreatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User UserOrder;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> OrderItems = new ArrayList<OrderItem>();

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public float getOrderTotalPrice() {
        return OrderTotalPrice;
    }

    public void setOrderTotalPrice(float orderTotalPrice) {
        OrderTotalPrice = orderTotalPrice;
    }

    public LocalDate getOrderCreatedDate() {
        return OrderCreatedDate;
    }

    public void setOrderCreatedDate(LocalDate orderCreatedDate) {
        OrderCreatedDate = orderCreatedDate;
    }

    public User getUserOrder() {
        return UserOrder;
    }

    public void setUserOrder(User userOrder) {
        UserOrder = userOrder;
    }

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        OrderItems = orderItems;
    }

    public float TotalPrice()
    {
        List<OrderItem> items = this.getOrderItems();
        float price = 0;
        for(int i = 0; i < items.size(); i++)
        {
            OrderItem item = items.get(i);
            price  += item.getOrderItemTotalPrice();
        }
        return price;
    }
}
