package com.ownsolutiongroup.rentACar.repository;

import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.repository.custom.DriverRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Long> , DriverRepositoryCustom {
}
