package com.epam.mentoring.module03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    private interface SimpleInterface {
        int calculate(int a, int b);
    }

    private interface Factory<T> {
        T make();
    }

    public static void main(String[] args) {
        System.out.println("Java Mentoring Program - Module 3");

        // Single Abstract Method Interface
        // Interface with one method
        // For example, Runnable
        // Annotation @FunctionalInterface

        SimpleInterface functionalInterfaceObjectExample = (a, b) -> {
            System.out.println("First argument: " + a);
            System.out.println("Second argument: " + b);
            return a + b;
        };

        System.out.println(functionalInterfaceObjectExample.calculate(2, 3));
        System.out.println(functionalInterfaceObjectExample.calculate(5, 8));

        Factory<List<String>> stringListFactory = ArrayList::new;
        Collection<String> stringCollectionExample = stringListFactory.make();
        stringCollectionExample.add("String Example #1");

        System.out.println(stringCollectionExample.size());
    }
}
