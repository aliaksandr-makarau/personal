package com.epam.mentoring.module0902.services;

import com.epam.mentoring.module0902.beans.Cab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Cab> getCabs() {
        return jdbcTemplate.query("SELECT * FROM cab", (rs, rowNumber) -> new Cab(
                rs.getDate("manufacture_year"),
                rs.getString("car_make"),
                rs.getString("licence_plate"),
                rs.getBoolean("has_baby_chair")
        ));
    }
}
