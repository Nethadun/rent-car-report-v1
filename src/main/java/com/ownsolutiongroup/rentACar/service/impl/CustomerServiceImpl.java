package com.ownsolutiongroup.rentACar.service.impl;

import com.ownsolutiongroup.rentACar.builder.DtoBuilder;
import com.ownsolutiongroup.rentACar.builder.EntityBuilder;
import com.ownsolutiongroup.rentACar.dto.CustomerDto;
import com.ownsolutiongroup.rentACar.entity.Customer;
import com.ownsolutiongroup.rentACar.repository.CustomerRepository;
import com.ownsolutiongroup.rentACar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DtoBuilder dtoBuilder;
    @Override
    public Long add(CustomerDto customerDto) {
        Customer saved = customerRepository.save(entityBuilder.customerEntityBuilder(new Customer(), customerDto));
        return null !=saved ? saved.getId() : null;
    }

    @Override
    public Long update(CustomerDto customerDto) {
        Customer saved = customerRepository.save(entityBuilder.customerEntityBuilder(new Customer(), customerDto));
        return null !=saved ? saved.getId() : null;
    }

    @Override
    public List<CustomerDto> searchLike(String searchText, Integer count, Integer page) {
        List<CustomerDto> list= new ArrayList<>();

        for (Customer entity : customerRepository.search(searchText, count,page)){
            list.add(dtoBuilder.customerDtoBuilder(entity));
        }
        return list;
    }

    @Override
    public CustomerDto get(Long id) {
        return dtoBuilder.customerDtoBuilder(customerRepository.getOne(id));
    }

    @Override
    public Long delete(Long id) {
        Customer customer = customerRepository.getOne(id);
        customer.setIsEnable(0);
        Customer saved = customerRepository.save(customer);
        return null !=saved ? saved.getId() : null;
    }
}
