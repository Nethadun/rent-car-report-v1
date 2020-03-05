package com.ownsolutiongroup.rentACar.controller;

import com.ownsolutiongroup.rentACar.dto.VehicleDto;
import com.ownsolutiongroup.rentACar.dto.response.ResponseDto;
import com.ownsolutiongroup.rentACar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/osg/rent/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public ResponseDto addVehicle(@RequestBody VehicleDto vehicleDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= vehicleService.add(vehicleDto);
            message="Vehicle Created";
            status=200;

        }catch (NullPointerException e){
            message="Vehicle Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateVehicle(@RequestBody VehicleDto vehicleDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= vehicleService.update(vehicleDto);
            message="Vehicle Updated";
            status=200;

        }catch (NullPointerException e){
            message="Vehicle Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @GetMapping("/{id}")
    public VehicleDto getId(@PathVariable("id")Long id){
        return vehicleService.get(id);
    }

    @GetMapping
    public List<VehicleDto> searchDriver(
            @RequestParam(value = "text",required = true) String text,
            @RequestParam(value = "count",required = true) Integer count,
            @RequestParam(value = "page",required = true) Integer page){
        return vehicleService.searchLike(text,count,page);
    }

    @DeleteMapping("/{id}")
    public Long deleteVehicle(@PathVariable("id")Long id){
        return vehicleService.delete(id);
    }
}
