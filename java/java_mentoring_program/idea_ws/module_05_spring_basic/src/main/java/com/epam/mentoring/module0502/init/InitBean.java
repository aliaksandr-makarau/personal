package com.epam.mentoring.module0502.init;

import org.springframework.beans.factory.InitializingBean;

public class InitBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitBean::afterPropertiesSet()");
    }
}
