package com.ownsolutiongroup.rentACar.repository.custom;

import com.ownsolutiongroup.rentACar.entity.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> search(String searchText, Integer count, Integer page);
}
