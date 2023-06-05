package com.upc.mongo.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}
