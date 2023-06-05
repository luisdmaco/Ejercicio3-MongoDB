package com.upc.mongo.repository;

import com.upc.mongo.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Students, String> {

    @Query("{ 'name' : ?0 }")
    public Students findByName(String name);

    @Query(value = "{ 'year' : ?0 }", fields = "{ 'name' : 1, 'year' : 1 }")
    List<Students> findAllBy(int year);

    public long count();
}

