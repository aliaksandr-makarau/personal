package com.epam.mentoring.module02;

import com.epam.mentoring.module02.annotations.Init;
import com.epam.mentoring.module02.annotations.MentoringExampleAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AnnotationWatcher {

    public static void inspectAnnotation(Class<?> service, Map<String, Object> services) {

        printNameAnnotationProperty(service);
        Object serviceObject = fillServices(service, services);
        printBasicReflectionData(service);
        Method initMethod = printInitAnnotationMethods(service);
        callInitMethod(initMethod, serviceObject);
    }

    private static void printNameAnnotationProperty(Class<?> service) {
        boolean isServiceAnnotationPresented = service.isAnnotationPresent(MentoringExampleAnnotation.class);
        if (isServiceAnnotationPresented) {
            MentoringExampleAnnotation serviceAnnotation = service.getAnnotation(MentoringExampleAnnotation.class);
            System.out.println(serviceAnnotation.name());
        }
    }

    private static Object fillServices(Class<?> service, Map<String, Object> services) {
        boolean isServiceAnnotationPresented = service.isAnnotationPresent(MentoringExampleAnnotation.class);
        if (isServiceAnnotationPresented) {
            try {
                Object serviceObject = service.newInstance();
                System.out.println("New service was created: " + serviceObject);
                services.put(service.getSimpleName(), serviceObject);

                return serviceObject;
            } catch (InstantiationException | IllegalAccessException e) {
                // TODO Print to log that service was not created
                e.printStackTrace();
            }
        }

        return null;
    }

    private static void printBasicReflectionData(Class<?> service) {

        System.out.println("Class::getName() " + service.getName());
        System.out.println("Class::getSimpleName() " + service.getSimpleName());
        System.out.println("Class::getSuperclass()::getName() " + service.getSuperclass().getSimpleName());
        System.out.println("Class::getModifiers() " + service.getModifiers());

        // Method getInterfaces() does NOT return interfaces of the super class
        System.out.println("Class::getInterfaces() " + service.getInterfaces());

        // Method getMethods() returns ONLY PUBLIC methods from the class and all super classes
        // Method getDeclaredMethods() return ALL methods ONLY from the class
        System.out.println("Class::getMethods() " + service.getMethods());
        System.out.println("Class::getDeclaredMethods() " + service.getDeclaredMethods());
    }

    private static Method printInitAnnotationMethods(Class<?> service) {

        Method[] serviceMethods = service.getMethods();

        for (Method curMethod : serviceMethods) {
            if (curMethod.isAnnotationPresent(Init.class)) {
                System.out.println("Method with Init annotation " + curMethod.getName());
                return curMethod;
            }
        }

        return null;
    }

    private static void callInitMethod(Method initMethod, Object serviceObject) {
        if ((null != initMethod) && (null != serviceObject)) {
            Object[] methodParameters = new Object[] {};

            try {
                // for private method
                initMethod.setAccessible(true);
                initMethod.invoke(serviceObject, methodParameters);
            } catch (IllegalAccessException | InvocationTargetException e) {
                // TODO Print to log that service was not created

                if (initMethod.getAnnotation(Init.class).suppressException()) {
                    System.out.println("Exceptions are suppressed.");
                } else {
                    System.out.println("Exceptions are not suppressed.");
                    e.printStackTrace();
                }
            }
        }
    }
}
