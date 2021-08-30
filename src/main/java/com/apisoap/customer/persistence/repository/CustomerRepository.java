package com.apisoap.customer.persistence.repository;

import com.apisoap.customer.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Optional<Customer> findByDocumentNumber(String documentNumber);

}
