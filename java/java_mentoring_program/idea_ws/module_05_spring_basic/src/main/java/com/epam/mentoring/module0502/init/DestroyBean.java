package com.epam.mentoring.module0502.init;

import org.springframework.beans.factory.DisposableBean;

public class DestroyBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DestroyBean::destroy");
    }
}
