package com.app;

import com.app.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import javax.management.Query;
import org.hibernate.tool.schema.TargetType;

import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Category Smartphone = new Category();
        Smartphone.setCategoryName("Smartphone");

        Category Laptop = new Category();
        Laptop.setCategoryName("Laptop");

        Shipper Apple = new Shipper();
        Apple.setShipperName("Apple");
        Apple.setShipperCountry("USA");
        Apple.setShipperFoundationYear(LocalDate.MIN.withYear(1976));
        Apple.setShipperDirectorName("Tim Cook");

        Shipper Samsung = new Shipper();
        Samsung.setShipperName("Samsung");
        Samsung.setShipperCountry("South Korea");
        Samsung.setShipperFoundationYear(LocalDate.MIN.withYear(1938));
        Samsung.setShipperDirectorName("Johnny Shi Chunchan");

        Shipper Hp = new Shipper();
        Hp.setShipperName("Hp inc");
        Hp.setShipperCountry("USA");
        Hp.setShipperFoundationYear(LocalDate.MIN.withYear(1939));
        Hp.setShipperDirectorName("Enrique Lores");

        Product SamsungS22 = new Product();
        SamsungS22.setProductName("Samsung Galaxy S22");
        SamsungS22.setProductYearOfProduction(LocalDate.MIN.withYear(2022));
        SamsungS22.setProductDetails("Perfect mobile phone for everyone");
        SamsungS22.setProductPrice(19000);
        SamsungS22.setProductCount(60);
        SamsungS22.setProductDiscount(0);
        SamsungS22.setCategory(Smartphone);
        SamsungS22.setShipper(Samsung);

        Product Iphone11 = new Product();
        Iphone11.setProductName("Iphone 11 64GB");
        Iphone11.setProductYearOfProduction(LocalDate.MIN.withYear(2020));
        Iphone11.setProductDetails("Perfect mobile phone not for everyone");
        Iphone11.setProductPrice(25000);
        Iphone11.setProductCount(32);
        Iphone11.setProductDiscount(0);
        Iphone11.setCategory(Smartphone);
        Iphone11.setShipper(Apple);

        Product HPPavilion = new Product();
        HPPavilion.setProductName("'HP Pavilion 15");
        HPPavilion.setProductYearOfProduction(LocalDate.MIN.withYear(2018));
        HPPavilion.setProductDetails("Laptop standart");
        HPPavilion.setProductPrice(15000);
        HPPavilion.setProductCount(7);
        HPPavilion.setProductDiscount(10);
        HPPavilion.setCategory(Laptop);
        HPPavilion.setShipper(Hp);

        User dimqacs = new User();
        dimqacs.setUserName("Dmitrii");
        dimqacs.setUserSurname("Dzic");
        dimqacs.setUserPhone("+373 68 303 798");
        dimqacs.setUserEmail("dzicdmitrii@gmail.com");
        dimqacs.setUserRegistredDate(LocalDate.of(2020,1,1));

        User iulianocika = new User();
        iulianocika.setUserName("Iulia");
        iulianocika.setUserSurname("Dzic");
        iulianocika.setUserPhone("+373 68 983 007");
        iulianocika.setUserEmail("blaknight444@gmail.com");
        iulianocika.setUserRegistredDate(LocalDate.of(2022,8,10));

        User nasya = new User();
        nasya.setUserName("Nastya");
        nasya.setUserSurname("Melnic");
        nasya.setUserPhone("+373 68 143 168");
        nasya.setUserEmail("melnicnastya@gmail.com");
        nasya.setUserRegistredDate(LocalDate.of(2021,5,24));

        User kinnaamf = new User();
        kinnaamf.setUserName("Dmitrii");
        kinnaamf.setUserSurname("Melnic");
        kinnaamf.setUserPhone("+373 78 606 595");
        kinnaamf.setUserEmail("melnicdmitrii@mail.ru");
        kinnaamf.setUserRegistredDate(LocalDate.of(2021,9,15));

        Order firstOrder = new Order();
        firstOrder.setUserOrder(dimqacs);
        firstOrder.setOrderCreatedDate(LocalDate.of(2022,5,6));
        firstOrder.setOrderStatus("Delivered");

        Order secondOrder = new Order();
        secondOrder.setUserOrder(kinnaamf);
        secondOrder.setOrderCreatedDate(LocalDate.of(2023,4,15));
        secondOrder.setOrderStatus("Not Delivered");

        OrderItem firstItem = new OrderItem();
        firstItem.setProduct(Iphone11);
        firstItem.setOrder(firstOrder);
        firstItem.setOrderItemCount(2);
        firstItem.setOrderItemTotalPrice(firstItem.TotalPrice());
        firstOrder.getOrderItems().add(firstItem);

        OrderItem secondItem = new OrderItem();
        secondItem.setProduct(HPPavilion);
        secondItem.setOrder(secondOrder);
        secondItem.setOrderItemCount(1);
        secondItem.setOrderItemTotalPrice(secondItem.TotalPrice());
        secondOrder.getOrderItems().add(secondItem);

        OrderItem thirdItem = new OrderItem();
        thirdItem.setProduct(SamsungS22);
        thirdItem.setOrder(secondOrder);
        thirdItem.setOrderItemCount(1);
        thirdItem.setOrderItemTotalPrice(thirdItem.TotalPrice());
        secondOrder.getOrderItems().add(thirdItem);

        firstOrder.setOrderTotalPrice(firstOrder.TotalPrice());
        secondOrder.setOrderTotalPrice(secondOrder.TotalPrice());


        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Product.class).addAnnotatedClass(Shipper.class).addAnnotatedClass(Category.class).addAnnotatedClass(User.class).addAnnotatedClass(Order.class).addAnnotatedClass(OrderItem.class);

        StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory Factory = con.buildSessionFactory(ssb.build());


        Session session = Factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(Smartphone);
        session.persist(Laptop);
        session.persist(Samsung);
        session.persist(Apple);
        session.persist(Hp);
        session.persist(SamsungS22);
        session.persist(Iphone11);
        session.persist(HPPavilion);
        session.persist(dimqacs);
        session.persist(iulianocika);
        session.persist(nasya);
        session.persist(kinnaamf);
        session.persist(firstOrder);
        session.persist(secondOrder);
        session.persist(firstItem);
        session.persist(secondItem);
        session.persist(thirdItem);

        transaction.commit();
        session.close();
    }
}