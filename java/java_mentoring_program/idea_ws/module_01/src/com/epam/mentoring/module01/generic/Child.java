package com.epam.mentoring.module01.generic;

public class Child extends Parent {

	// Compilation ERROR
	// @Override
	public static void staticFoo() {
		System.out.println("Parent::staticFoo()");
	}
	
}
