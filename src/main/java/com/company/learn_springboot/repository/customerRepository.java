package com.company.learn_springboot.repository;

import com.company.learn_springboot.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface customerRepository extends JpaRepository<Customer, Integer> {

}
