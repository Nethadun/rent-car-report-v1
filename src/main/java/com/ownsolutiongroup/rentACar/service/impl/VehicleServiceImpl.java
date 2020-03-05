package com.ownsolutiongroup.rentACar.service.impl;

import com.ownsolutiongroup.rentACar.builder.DtoBuilder;
import com.ownsolutiongroup.rentACar.builder.EntityBuilder;
import com.ownsolutiongroup.rentACar.dto.VehicleDto;
import com.ownsolutiongroup.rentACar.entity.Vehicle;
import com.ownsolutiongroup.rentACar.repository.VehicleRepository;
import com.ownsolutiongroup.rentACar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DtoBuilder dtoBuilder;
    @Override
    public Long add(VehicleDto vehicleDto) {
        Vehicle saved = vehicleRepository.save(entityBuilder.vehicleEntityBuilder(new Vehicle(), vehicleDto));
        return null !=saved ? saved.getId() : null;
    }

    @Override
    public Long update(VehicleDto vehicleDto) {
        Vehicle saved = vehicleRepository.save(entityBuilder.vehicleEntityBuilder(new Vehicle(), vehicleDto));
        return null !=saved ? saved.getId() :null;
    }

    @Override
    public List<VehicleDto> searchLike(String searchText, Integer count, Integer page) {
        List<VehicleDto> list= new ArrayList<>();
        for (Vehicle entity : vehicleRepository.search(searchText, count,page)){
            list.add(dtoBuilder.vehicleDtoBuilder(entity));
        }
        return list;

    }

    @Override
    public VehicleDto get(Long id) {
        return dtoBuilder.vehicleDtoBuilder(vehicleRepository.getOne(id));
    }

    @Override
    public Long delete(Long id) {
        Vehicle vehicle = vehicleRepository.getOne(id);
        vehicle.setIsEnable(0);
        Vehicle saved = vehicleRepository.save(vehicle);
        return null !=saved ? saved.getId() : null;
    }
}
