package com.upc.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("students")
public class Students {
    @Id
    private String id;
    private Address address;
    private List<String> courses;
    private String name;
    private int year;

    public Students(String name, int year, Address address, List<String> courses) {
        this.address = address;
        this.courses = courses;
        this.name = name;
        this.year = year;
    }
}
