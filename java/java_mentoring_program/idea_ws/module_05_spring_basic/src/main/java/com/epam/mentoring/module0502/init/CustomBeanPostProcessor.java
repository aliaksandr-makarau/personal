package com.epam.mentoring.module0502.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class CustomBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("CustomBeanPostProcessor::postProcessBeforeInitialization for " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("CustomBeanPostProcessor::postProcessAfterInitialization for " + s);
        return o;
    }

    @Override
    public int getOrder() {
        return 200;
    }
}
