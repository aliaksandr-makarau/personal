package com.epam.mentoring.module03.tasks;

import com.epam.mentoring.module03.model.BusinessTask;

public class BusinessTaskUpdateCustomerAge implements BusinessTask {

    @Override
    public void updateStateInDB() {
        System.out.println("BusinessTaskUpdateCustomerAge::updateStateInDB()");
    }
}
