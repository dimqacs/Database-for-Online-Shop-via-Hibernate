package com.app.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INTEGER")
    private int ShipperId;

    @Column(name = "Name", columnDefinition = "VARCHAR(99)")
    private String ShipperName;

    @Column(name = "Country", columnDefinition = "VARCHAR(99)")
    private String ShipperCountry;

    @Column(name = "FoundationYear", columnDefinition = "DATE")
    private LocalDate ShipperFoundationYear;

    @Column(name = "Director", columnDefinition = "VARCHAR(99)")
    private String ShipperDirectorName;

    public Shipper(){};

    public int getShipperId() {
        return ShipperId;
    }

    public void setShipperId(int shipperId) {
        ShipperId = shipperId;
    }

    public String getShipperName() {
        return ShipperName;
    }

    public void setShipperName(String shipperName) {
        ShipperName = shipperName;
    }

    public String getShipperCountry() {
        return ShipperCountry;
    }

    public void setShipperCountry(String shipperCountry) {
        ShipperCountry = shipperCountry;
    }

    public LocalDate getShipperFoundationYear() {
        return ShipperFoundationYear;
    }

    public void setShipperFoundationYear(LocalDate shipperFoundationYear) {
        ShipperFoundationYear = shipperFoundationYear;
    }

    public String getShipperDirectorName() {
        return ShipperDirectorName;
    }

    public void setShipperDirectorName(String shipperDirectorName) {
        ShipperDirectorName = shipperDirectorName;
    }

}
