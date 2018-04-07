package com.amm.mentoring.core.lecture1.run;

public class Child extends Parent {

	// Compilation ERROR
	// @Override
	public static void staticFoo() {
		System.out.println("Parent::staticFoo()");
	}
	
}
