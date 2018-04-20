package com.epam.mentoring.module02.services;

import com.epam.mentoring.module02.annotations.Init;
import com.epam.mentoring.module02.annotations.MentoringExampleAnnotation;

@MentoringExampleAnnotation(name = "VeryLazyService")
public class LazyService {

    @Init
    public void initLazy() throws Exception {
        System.out.println("LazyService::intiLazy()");
    }
}
