package com.ownsolutiongroup.rentACar.controller;

import com.ownsolutiongroup.rentACar.dto.DriverDto;
import com.ownsolutiongroup.rentACar.dto.response.ResponseDto;
import com.ownsolutiongroup.rentACar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/osg/rent/driver")
public class DriverController {
    @Autowired
    DriverService driverService;


    @PostMapping
    public ResponseDto addDriver(@RequestBody DriverDto driverDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= driverService.add(driverDto);
            message="Driver Created";
            status=200;

        }catch (NullPointerException e){
            message="Driver Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateDriver(@RequestBody DriverDto driverDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= driverService.update(driverDto);
            message="Driver Updated";
            status=200;

        }catch (NullPointerException e){
            message="Driver Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @GetMapping("/{id}")
    public DriverDto getId(@PathVariable("id")Long id){
        return driverService.get(id);
    }

    @GetMapping
    public List<DriverDto> searchDriver(
            @RequestParam(value = "text",required = true) String text,
            @RequestParam(value = "count",required = true) Integer count,
            @RequestParam(value = "page",required = true) Integer page){
        return driverService.searchLike(text,count,page);
    }

    @DeleteMapping("/{id}")
    public Long deleteDriver(@PathVariable("id")Long id){
        return driverService.delete(id);
    }
}
