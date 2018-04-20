package com.epam.mentoring.module02.services;

import com.epam.mentoring.module02.annotations.Init;
import com.epam.mentoring.module02.annotations.MentoringExampleAnnotation;

@MentoringExampleAnnotation(name = "SuperPuperService")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("SimpleService::initService()");
    }

    public void foo() {
        System.out.println("SimpleService::foo()");
    }
}
