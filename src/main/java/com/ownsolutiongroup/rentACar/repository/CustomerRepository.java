package com.ownsolutiongroup.rentACar.repository;

import com.ownsolutiongroup.rentACar.entity.Customer;
import com.ownsolutiongroup.rentACar.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long>, CustomerRepositoryCustom {
}
