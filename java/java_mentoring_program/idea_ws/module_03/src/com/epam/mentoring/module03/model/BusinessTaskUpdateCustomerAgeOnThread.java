package com.epam.mentoring.module03.model;

public class BusinessTaskUpdateCustomerAgeOnThread extends Thread implements BusinessTask {

    @Override
    public void run() {
        try {
            updateStateInDB();
            Thread.sleep(10000);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStateInDB() {
        System.out.println("BusinessTaskUpdateCustomerAgeOnThread::updateStateInDB()");
    }
}
