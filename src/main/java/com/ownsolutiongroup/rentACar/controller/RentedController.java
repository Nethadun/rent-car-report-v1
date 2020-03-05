package com.ownsolutiongroup.rentACar.controller;

import com.ownsolutiongroup.rentACar.dto.BookingDetailsDto;
import com.ownsolutiongroup.rentACar.dto.response.ResponseDto;
import com.ownsolutiongroup.rentACar.service.RentedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/osg/rent/rented")
public class RentedController {
    @Autowired
    RentedService rentedService;

    @PostMapping
    public ResponseDto addRented(@RequestBody BookingDetailsDto bookingDetailsDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= rentedService.add(bookingDetailsDto);
            message="Booking Placed ";
            status=200;

        }catch (NullPointerException e){
            message="Booking Not Placed ";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateRented(@RequestBody BookingDetailsDto bookingDetailsDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= rentedService.update(bookingDetailsDto);
            message="Booking Completed ";
            status=200;

        }catch (NullPointerException e){
            message="Booking Not Completed ";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }
}
