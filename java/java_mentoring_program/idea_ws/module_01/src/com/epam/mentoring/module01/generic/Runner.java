package com.epam.mentoring.module01.generic;

import java.io.Serializable;

public class Runner {
	
	static enum Planet {
		
		MERCURY(123456),
		VENUS(654321);
		
		private double mass;
		
		// A constructor of enum can be ONLY private
		private Planet(double mass) {
			this.mass = mass;
		}
		
		public double getMass() {
			return mass;
		}
		
	}
	
	static public void main(String[] args) {
		
		// 1. STATIC discussion
		
		System.out.println("Test for static overridable methods");
		// Java does NOT allow override a static method
		
		// 2. FINAL discussion
		// Does not allow change value of variable
		// Does not allow override a method
		// Does not allow inheritance from a class
		
		// 3. ENUM discussion
		@SuppressWarnings("unused")
		Planet aPlanet = Planet.MERCURY;
		System.out.println(Planet.valueOf("MERCURY"));
		
		// Not allowed
		// Planet anotherPlanet = new Planet();
		
		// 4. ANONYMOUS CLASSES
		new Serializable() {
			private static final long serialVersionUID = 1L;
		};		
		
		// 5. STRINGS
		// String is an immutable class
		// If a new string should be changed then a new String will be created
		double arg1 = 23;
		System.out.println(String.format("Some string with %f value", arg1));
		
		// Look for StringUtils in any libraries in Apache and Spring
		String cat1 = "Cat";
		String cat2 = "Cat";
		String cat3 = new String("Cat");
		String cat4 = cat3.intern();
		
		System.out.println(cat1 == cat2);
		System.out.println(cat1 == cat3);
		System.out.println(cat2 == cat3);
		
		System.out.println(cat1.equals(cat2));
		System.out.println(cat1.equals(cat3));
		System.out.println(cat1.equals(cat4));
		
		// StringBuffer and StringBuilder
		// StringBuilder is NOT thread safe
		// String pool
		
		// Reverse String
		String aString = "Just a simple String";
		for (int i = aString.length() - 1; i >= 0; --i) {
			System.out.print(aString.charAt(i));
		}
		
		System.out.println();
		System.out.println(new StringBuilder(aString).reverse());
		
		// 6. EXCEPTIONS
		// Stackoverflow Exception
		// try - catch - fanally
		// throw
		// throws
		
		// Throwable
		// Error | Exception
		// Exceptions <- Exceptions | RuntimeException
		// RuntimeException (Unchecked) <- NullPointerException | ArithmeticException
		// Exception (Checked) <- IOException
		
		// 7. FINALLY
		// Always except System.exit(0);
		// Note: If the JVM exits while the try or catch code is being executed, 
		// then the finally block may not execute. Likewise, if the thread executing 
		// the try or catch code is interrupted or killed, the finally block may 
		// not execute even though the application as a whole continues.
	}
	
}
