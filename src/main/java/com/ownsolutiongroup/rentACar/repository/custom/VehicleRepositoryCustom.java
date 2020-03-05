package com.ownsolutiongroup.rentACar.repository.custom;

import com.ownsolutiongroup.rentACar.entity.Vehicle;

import java.util.List;

public interface VehicleRepositoryCustom {
    List<Vehicle> search(String searchText, Integer count, Integer page);
}
