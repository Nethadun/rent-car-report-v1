package com.ownsolutiongroup.rentACar.service.impl;

import com.ownsolutiongroup.rentACar.dto.BookingDetailsDto;
import com.ownsolutiongroup.rentACar.entity.Book;
import com.ownsolutiongroup.rentACar.entity.BookingDetails;
import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.entity.Vehicle;
import com.ownsolutiongroup.rentACar.repository.*;
import com.ownsolutiongroup.rentACar.service.RentedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class RentedServiceImpl implements RentedService {
    @Autowired
    BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Long add(BookingDetailsDto bookingDetailsDto) {
        BookingDetails bookingDetailsSave = new BookingDetails();
        List<Vehicle> vehicleList=new ArrayList<>();
        List<Driver> driverList=new ArrayList<>();
        Book book=new Book();

        try{
            book.setId(bookingDetailsDto.getBookDto().getId());
            book.setCustomer(customerRepository.getOne(bookingDetailsDto.getBookDto().getCustomerId()));
            book.setRent_date(bookingDetailsDto.getBookDto().getRent_date());
            book.setIsEnable(1);
            Book bookSave = bookRepository.save(book);

            for (int i=0; i < bookingDetailsDto.getVehicleDtoList().size(); i++){
                Vehicle vehicle = vehicleRepository.getOne(bookingDetailsDto.getVehicleDtoList().get(i));
                vehicleList.add(vehicle);
                vehicle.setVehicle_status("Not Available");
                vehicleRepository.save(vehicle);
            }

            for (int j=0; j< bookingDetailsDto.getDriverDtoList().size();j++ ){
                Driver driver = driverRepository.getOne(bookingDetailsDto.getDriverDtoList().get(j));
                driverList.add(driver);
                driver.setDriver_status("Not Available");
                driverRepository.save(driver);
            }

            bookingDetailsSave.setId(bookingDetailsDto.getId());
            bookingDetailsSave.setVehicleList(vehicleList);
            bookingDetailsSave.setDriverList(driverList);
            bookingDetailsSave.setBook_ytpe(bookingDetailsDto.getBook_ytpe());
            bookingDetailsSave.setRented_date(bookingDetailsDto.getRented_date());
            bookingDetailsSave.setStart_mileage(bookingDetailsDto.getStart_mileage());
            bookingDetailsSave.setEnd_mileage(bookingDetailsDto.getEnd_mileage());
            bookingDetailsSave.setRented_cost(bookingDetailsDto.getRented_cost());
            bookingDetailsSave.setAdditional_cost(bookingDetailsDto.getAdditional_cost());
            bookingDetailsSave.setDamage_cost(bookingDetailsDto.getDamage_cost());
            bookingDetailsSave.setBooking_status("Pending..");
            bookingDetailsSave.setIsEnable(1);
            bookingDetailsSave.setBook(bookSave);

            bookingDetailsRepository.save(bookingDetailsSave);

        }catch (Exception e){
            e.printStackTrace();
        }
        return bookingDetailsSave.getId();
    }

    @Override
    public Long update(BookingDetailsDto bookingDetailsDto) {
        BookingDetails bookingDetailsSave = new BookingDetails();
        List<Vehicle> vehicleList=new ArrayList<>();
        List<Driver> driverList=new ArrayList<>();
        Book book=new Book();

        try{
            book.setId(bookingDetailsDto.getBookDto().getId());
            book.setCustomer(customerRepository.getOne(bookingDetailsDto.getBookDto().getCustomerId()));
            book.setRent_date(bookingDetailsDto.getBookDto().getRent_date());
            book.setIsEnable(1);
            Book bookSave = bookRepository.save(book);

            for (int i=0; i < bookingDetailsDto.getVehicleDtoList().size(); i++){
                Vehicle vehicle = vehicleRepository.getOne(bookingDetailsDto.getVehicleDtoList().get(i));
                vehicleList.add(vehicle);
                vehicle.setVehicle_status("Available");
                vehicleRepository.save(vehicle);
            }

            for (int j=0; j< bookingDetailsDto.getDriverDtoList().size();j++ ){
                Driver driver = driverRepository.getOne(bookingDetailsDto.getDriverDtoList().get(j));
                driverList.add(driver);
                driver.setDriver_status("Available");
                driverRepository.save(driver);
            }

            bookingDetailsSave.setId(bookingDetailsDto.getId());
            bookingDetailsSave.setVehicleList(vehicleList);
            bookingDetailsSave.setDriverList(driverList);
            bookingDetailsSave.setBook_ytpe(bookingDetailsDto.getBook_ytpe());
            bookingDetailsSave.setRented_date(bookingDetailsDto.getRented_date());
            bookingDetailsSave.setStart_mileage(bookingDetailsDto.getStart_mileage());
            bookingDetailsSave.setEnd_mileage(bookingDetailsDto.getEnd_mileage());
            bookingDetailsSave.setRented_cost(bookingDetailsDto.getRented_cost());
            bookingDetailsSave.setAdditional_cost(bookingDetailsDto.getAdditional_cost());
            bookingDetailsSave.setDamage_cost(bookingDetailsDto.getDamage_cost());
            bookingDetailsSave.setBooking_status("Done");
            bookingDetailsSave.setIsEnable(1);
            bookingDetailsSave.setBook(bookSave);

            bookingDetailsRepository.save(bookingDetailsSave);

        }catch (Exception e){
            e.printStackTrace();
        }
        return bookingDetailsSave.getId();
    }

    @Override
    public List<BookingDetailsDto> searchLike(String searchText, Integer count, Integer page) {
        return null;
    }

    @Override
    public BookingDetailsDto get(Long id) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
