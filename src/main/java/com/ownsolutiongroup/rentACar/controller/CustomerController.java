package com.ownsolutiongroup.rentACar.controller;

import com.ownsolutiongroup.rentACar.dto.CustomerDto;
import com.ownsolutiongroup.rentACar.dto.response.ResponseDto;
import com.ownsolutiongroup.rentACar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/osg/rent/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseDto addCustomer(@RequestBody CustomerDto customerDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= customerService.add(customerDto);
            message="Customer Created";
            status=200;

        }catch (NullPointerException e){
            message="Customer Not Created";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @PutMapping
    public ResponseDto updateCustomer(@RequestBody CustomerDto customerDto){
        Long id=null;
        String message=null;
        int status =0;

        try {
            id= customerService.update(customerDto);
            message="Customer Updated";
            status=200;

        }catch (NullPointerException e){
            message="Customer Not Updated";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDto(id,status,message);
    }

    @GetMapping("/{id}")
    public CustomerDto getId(@PathVariable("id")Long id){
        return customerService.get(id);
    }

    @GetMapping
    public List<CustomerDto> searchCustomer(
            @RequestParam(value = "text",required = true) String text,
            @RequestParam(value = "count",required = true) Integer count,
            @RequestParam(value = "page",required = true) Integer page){
        return customerService.searchLike(text,count,page);
    }

    @DeleteMapping("/{id}")
    public Long deleteCustomer(@PathVariable("id")Long id){
        return customerService.delete(id);
    }
}
