package com.ownsolutiongroup.rentACar.repository.custom.impl;

import com.ownsolutiongroup.rentACar.entity.Driver;
import com.ownsolutiongroup.rentACar.repository.custom.DriverRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Driver> search(String searchText, Integer count, Integer page) {
        Query q=entityManager.createNativeQuery("select d.* from driver  d where (d.driver_name like :searchText ) and d.is_enable=1", Driver.class);
        q.setParameter("searchText","%"+ searchText + "%");
        q.setFirstResult(page * count);
        q.setMaxResults(count);
        return q.getResultList();
    }
}
