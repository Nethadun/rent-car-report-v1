package com.ownsolutiongroup.rentACar.repository.custom;

import com.ownsolutiongroup.rentACar.entity.Driver;

import java.util.List;

public interface DriverRepositoryCustom {
    List<Driver> search(String searchText, Integer count, Integer page);
}
