package com.epam.mentoring.module05;

import com.epam.mentoring.module05.factorydemo.factory.BioReactor;
import com.epam.mentoring.module05.factorydemo.model.Human;
import com.epam.mentoring.module05.factorydemo.model.SuperHero;
import com.epam.mentoring.module05.springdemo.beans.Developer;
import com.epam.mentoring.module05.springdemo.beans.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Evolution of programming concept
        // - procedure style
        // - OOP with encapsulation
        // - Interfaces with implementations (allows divide abstractions and code by layers)
        // - Factory pattern
        // - Dependency injection (very useful for unit testing)

        // Interface style example:
        Human humanOnInterface = new SuperHero();
        humanOnInterface.speak();

        // Factory style example:
        Human humanFromFactory = BioReactor.getHuman("SuperHero");
        humanFromFactory.speak();

        // Inversion of Control (IoC) - concept to avoid unnecessary binding between abstractions
        // Dependency Injection (DI)

        // 2. Spring
        // Action of a Spring container:
        // - creates the objects;
        // - configures the objects;
        // - wires the objects together
        // - manages lifecycle of the objects from creation till destruction

        // Main terms:
        // - Application context
        // - Bean
        // - Bean definition

        // Lifecycle of App context:
        // - Initialization
        // - Usage
        // - Destruction

        // Beans can be defined in several ways:
        // - xml
        // - Java configuration
        // - Annotations
        // - Groovy
        // - Spring Boot

        // Setter injection
        // Constructor injection

        ApplicationContext appContext = new ClassPathXmlApplicationContext("Beans.xml");
        Developer dev = (Developer) appContext.getBean("dev");
        System.out.println(dev);

        Developer intern = appContext.getBean("intern", Developer.class);
        intern.setLevel(1);
        intern.setSkill("Kotlin");
        System.out.println(intern);

        Developer dotNetDev = appContext.getBean("dotNetDev", Developer.class);
        System.out.println(dotNetDev);

        Developer anonimous = appContext.getBean("anonimous", Developer.class);
        System.out.println(anonimous);

        Project taxiBumer = appContext.getBean("taxiBumer", Project.class);
        System.out.println(taxiBumer);

        Project java10 = appContext.getBean("Java 10", Project.class);
        System.out.println(java10);

        // Singletone is the default scope for a bean in Spring
        Developer scalaIntern = appContext.getBean("scalaDev", Developer.class);
        scalaIntern.setSkill("Delphi");
        System.out.println(scalaIntern);

        Developer scalaDev = appContext.getBean("scalaDev", Developer.class);
        System.out.println(scalaDev);

        System.out.println("Are Scala intern and Scala developer the same? " + (scalaDev == scalaIntern));

        ApplicationContext secondContextInstance = new ClassPathXmlApplicationContext("Beans.xml");

        Developer scalaInternFromSecond = secondContextInstance.getBean("scalaDev", Developer.class);
        scalaInternFromSecond.setSkill("Delphi");
        System.out.println(scalaInternFromSecond);

        Developer scalaDevFromSecond = appContext.getBean("scalaDev", Developer.class);
        System.out.println(scalaDevFromSecond);

        System.out.println("Are Scala intern from First and from Second the same? " +
                (scalaInternFromSecond == scalaIntern));

        List<Developer> devs = appContext.getBean("devs", List.class);
        devs.stream().forEach(System.out::println);
    }
}
