package com.epam.mentoring.module02;

import com.epam.mentoring.module02.services.LazyService;
import com.epam.mentoring.module02.services.SimpleService;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java Mentoring Program - Module 2");

        Map<String, Object> services = new HashMap<>();

        getClassInfo(SimpleService.class, services);
        getClassInfo(LazyService.class, services);
        getClassInfo(String.class, services);

        System.out.println("Services created: " + services.size());
    }

    private static void getClassInfo(Class<?> anyClass, Map<String, Object> services) {
        System.out.println(anyClass.getSimpleName() + " class: ");
        AnnotationWatcher.inspectAnnotation(anyClass, services);
        System.out.println();
    }

}
