package com.ownsolutiongroup.rentACar.repository;

import com.ownsolutiongroup.rentACar.entity.Vehicle;
import com.ownsolutiongroup.rentACar.repository.custom.VehicleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle , Long> , VehicleRepositoryCustom {
}
