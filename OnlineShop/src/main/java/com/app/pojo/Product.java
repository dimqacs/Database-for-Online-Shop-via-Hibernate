package com.app.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INTEGER")
    private int ProductId;

    @Column(name = "Name", columnDefinition = "VARCHAR(255)")
    private String ProductName;

    @Column(name = "YearOfProduction", columnDefinition = "DATE")
    private LocalDate ProductYearOfProduction;

    @Column(name = "Details", columnDefinition = "VARCHAR(1000)")
    private String ProductDetails;

    @Column(name = "Price", columnDefinition = "FLOAT")
    private float ProductPrice;

    @Column(name = "Count", columnDefinition = "INTEGER")
    private int ProductCount;

    @Column(name = "Discount", columnDefinition = "INTEGER")
    private int ProductDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shipper Shipper;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category Category;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> ProductsOrdered = new ArrayList<OrderItem>();

    public Product(){};

    public int getProductId() {
        return ProductId;
    }

        public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public LocalDate getProductYearOfProduction() {
        return ProductYearOfProduction;
    }

    public void setProductYearOfProduction(LocalDate productYearOfProduction) {
        ProductYearOfProduction = productYearOfProduction;
    }

    public String getProductDetails() {
        return ProductDetails;
    }

    public void setProductDetails(String productDetails) {
        ProductDetails = productDetails;
    }

    public float getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(float productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int productCount) {
        ProductCount = productCount;
    }

    public int getProductDiscount() {
        return ProductDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        ProductDiscount = productDiscount;
    }

    public com.app.pojo.Shipper getShipper() {
        return Shipper;
    }

    public void setShipper(com.app.pojo.Shipper shipper) {
        Shipper = shipper;
    }

    public com.app.pojo.Category getCategory() {
        return Category;
    }

    public void setCategory(com.app.pojo.Category category) {
        Category = category;
    }

    public List<OrderItem> getProductsOrdered() {
        return ProductsOrdered;
    }

    public void setProductsOrdered(List<OrderItem> productsOrdered) {
        ProductsOrdered = productsOrdered;
    }
}
