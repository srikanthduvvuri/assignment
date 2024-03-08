package com.devops.assignment.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.devops.assignment.model.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    /*
     * the 2nd parameter is String because the identifier (Id) for Customer is of
     * type String
     */

    @Query("{custId:'?0'}")
    Customer findByCustId(String custId);

}
