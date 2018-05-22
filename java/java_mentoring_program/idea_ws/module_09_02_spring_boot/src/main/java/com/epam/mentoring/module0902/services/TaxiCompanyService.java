package com.epam.mentoring.module0902.services;

import com.epam.mentoring.module0902.beans.TaxiCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaxiCompanyService extends CrudRepository<TaxiCompany, Long> {

    public List<TaxiCompany> findByName(String name);
}
