package com.epam.mentoring.module03.model;

public interface BusinessTask {

    void updateStateInDB();

    default void updateStateInMemory() {
        System.out.println("BusinessTask::updateStateInMemory()");
    }
}
