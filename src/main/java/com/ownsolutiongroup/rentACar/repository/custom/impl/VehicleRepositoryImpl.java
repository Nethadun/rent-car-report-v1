package com.ownsolutiongroup.rentACar.repository.custom.impl;

import com.ownsolutiongroup.rentACar.entity.Customer;
import com.ownsolutiongroup.rentACar.entity.Vehicle;
import com.ownsolutiongroup.rentACar.repository.custom.CustomerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class VehicleRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> search(String searchText, Integer count, Integer page) {
        Query q=entityManager.createNativeQuery("select v.* from vehicle  v where (v.vehicle_model like :searchText ) and v.is_enable=1", Vehicle.class);
        q.setParameter("searchText","%"+ searchText + "%");
        q.setFirstResult(page * count);
        q.setMaxResults(count);
        return q.getResultList();
    }
}
