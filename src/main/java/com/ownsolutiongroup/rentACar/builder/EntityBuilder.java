package com.ownsolutiongroup.rentACar.builder;

import com.ownsolutiongroup.rentACar.dto.CustomerDto;
import com.ownsolutiongroup.rentACar.dto.DriverDto;
import com.ownsolutiongroup.rentACar.dto.VehicleDto;
import com.ownsolutiongroup.rentACar.entity.Customer;
import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class EntityBuilder {
    public Customer customerEntityBuilder(Customer customer, CustomerDto customerDto){
        if(customerDto == null){
            return null;
        }

        customer.setId(customerDto.getId());
        customer.setCustomer_name(customerDto.getCustomer_name());
        customer.setCustomer_nic(customerDto.getCustomer_nic());
        customer.setCustomer_driving_licence(customerDto.getCustomer_driving_licence());
        customer.setCustomer_address(customerDto.getCustomer_address());
        customer.setCustomer_age(customerDto.getCustomer_age());
        customer.setCustomer_telephone(customerDto.getCustomer_telephone());
        customer.setIsEnable(1);

        return customer;
    }

    public Vehicle vehicleEntityBuilder(Vehicle vehicle, VehicleDto vehicleDto){
        if(vehicleDto ==null){
            return null;
        }

        vehicle.setId(vehicleDto.getId());
        vehicle.setVehicle_model(vehicleDto.getVehicle_model());
        vehicle.setVehicle_type(vehicleDto.getVehicle_type());
        vehicle.setVehicle_color(vehicleDto.getVehicle_color());
        vehicle.setVehicle_no(vehicleDto.getVehicle_no());
        vehicle.setEngine_no(vehicleDto.getEngine_no());
        vehicle.setChassis_no(vehicleDto.getChassis_no());
        vehicle.setVehicle_engine_capacity(vehicleDto.getVehicle_engine_capacity());
        vehicle.setVehicle_status(vehicleDto.getVehicle_status());
        vehicle.setIsEnable(1);

        return vehicle;
    }

    public Driver driverEntityBuilder(Driver driver , DriverDto driverDto){
        if (driverDto == null){
            return null;
        }

        driver.setId(driverDto.getId());
        driver.setDriver_name(driverDto.getDriver_name());
        driver.setDriver_nic(driverDto.getDriver_nic());
        driver.setDriver_licence_no(driverDto.getDriver_licence_no());
        driver.setDriver_age(driverDto.getDriver_age());
        driver.setDriver_address(driverDto.getDriver_address());
        driver.setDriver_tel(driverDto.getDriver_tel());
        driver.setDriver_status(driverDto.getDriver_status());
        driver.setIsEnable(1);

        return driver;
    }
}
