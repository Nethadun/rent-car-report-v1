package com.ownsolutiongroup.rentACar.service.impl;

import com.ownsolutiongroup.rentACar.builder.DtoBuilder;
import com.ownsolutiongroup.rentACar.builder.EntityBuilder;
import com.ownsolutiongroup.rentACar.dto.DriverDto;
import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.repository.DriverRepository;
import com.ownsolutiongroup.rentACar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DtoBuilder dtoBuilder;
    @Override
    public Long add(DriverDto driverDto) {
        Driver saved = driverRepository.save(entityBuilder.driverEntityBuilder(new Driver(), driverDto));
        return null != saved ? saved.getId() :null;
    }

    @Override
    public Long update(DriverDto driverDto) {
        Driver saved = driverRepository.save(entityBuilder.driverEntityBuilder(new Driver(), driverDto));
        return null != saved ? saved.getId() :null;
    }

    @Override
    public List<DriverDto> searchLike(String searchText, Integer count, Integer page) {
        List<DriverDto> list=new ArrayList<>();
        for (Driver entity : driverRepository.search(searchText, count,page)){
            list.add(dtoBuilder.driverDtoBuilder(entity));
        }
        return list;
    }

    @Override
    public DriverDto get(Long id) {
        return dtoBuilder.driverDtoBuilder(driverRepository.getOne(id));
    }

    @Override
    public Long delete(Long id) {
        Driver driver = driverRepository.getOne(id);
        driver.setIsEnable(0);
        Driver saved = driverRepository.save(driver);
        return null !=saved ? saved.getId() : null;
    }
}
