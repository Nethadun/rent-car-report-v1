package com.ownsolutiongroup.rentACar.builder;

import com.ownsolutiongroup.rentACar.dto.BookDto;
import com.ownsolutiongroup.rentACar.dto.CustomerDto;
import com.ownsolutiongroup.rentACar.dto.DriverDto;
import com.ownsolutiongroup.rentACar.dto.VehicleDto;
import com.ownsolutiongroup.rentACar.entity.Book;
import com.ownsolutiongroup.rentACar.entity.Customer;
import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class DtoBuilder {
    public CustomerDto customerDtoBuilder(Customer customer){
        if (customer ==null){
            return null;
        }

        CustomerDto customerDto=new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomer_name(customer.getCustomer_name());
        customerDto.setCustomer_nic(customer.getCustomer_nic());
        customerDto.setCustomer_driving_licence(customer.getCustomer_driving_licence());
        customerDto.setCustomer_address(customer.getCustomer_address());
        customerDto.setCustomer_age(customer.getCustomer_age());
        customerDto.setCustomer_telephone(customer.getCustomer_telephone());
        customerDto.setIsEnable(customer.getIsEnable());

        return customerDto;
    }

    public VehicleDto vehicleDtoBuilder(Vehicle vehicle){
        if (vehicle == null){
            return null;
        }

        VehicleDto vehicleDto=new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setVehicle_model(vehicle.getVehicle_model());
        vehicleDto.setVehicle_type(vehicle.getVehicle_type());
        vehicleDto.setVehicle_color(vehicle.getVehicle_color());
        vehicleDto.setVehicle_no(vehicle.getVehicle_no());
        vehicleDto.setEngine_no(vehicle.getEngine_no());
        vehicleDto.setChassis_no(vehicle.getChassis_no());
        vehicleDto.setVehicle_engine_capacity(vehicle.getVehicle_engine_capacity());
        vehicleDto.setVehicle_status(vehicle.getVehicle_status());
        vehicleDto.setIsEnable(vehicle.getIsEnable());

        return vehicleDto;
    }

    public DriverDto driverDtoBuilder(Driver driver){
        if (driver == null){
            return null;
        }

        DriverDto driverDto = new DriverDto();
        driverDto.setId(driver.getId());
        driverDto.setDriver_name(driver.getDriver_name());
        driverDto.setDriver_nic(driver.getDriver_nic());
        driverDto.setDriver_licence_no(driver.getDriver_licence_no());
        driverDto.setDriver_age(driver.getDriver_age());
        driverDto.setDriver_address(driver.getDriver_address());
        driverDto.setDriver_tel(driver.getDriver_tel());
        driverDto.setDriver_status(driver.getDriver_status());
        driverDto.setIsEnable(driver.getIsEnable());

        return driverDto;
    }



    public BookDto bookDtoBuilder(Book book){
        if(book == null){
            return null;
        }

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setCustomerDto(customerDtoBuilder(book.getCustomer()));
        bookDto.setCustomerId(bookDto.getCustomerDto().getId());
        bookDto.setIsEnable(1);

        return bookDto;
    }
}
