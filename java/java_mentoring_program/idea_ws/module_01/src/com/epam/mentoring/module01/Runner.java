package com.epam.mentoring.module01;

import com.epam.mentoring.module01.model.Camera;
import com.epam.mentoring.module01.model.Container;
import com.epam.mentoring.module01.model.Product;
import com.epam.mentoring.module01.model.SomeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Runner {

	public static class Basket<E> {
		
		private E element;
		
		public void setElement(E e) {
			element = e;
		}
		
		public E getElement() {
			return element;
		}
		
	}
	
	static class Fruit {}
	
	static class Apple extends Fruit {}
	
	static class Orange extends Fruit {}
	
	<T> T process(T item) {
		
		return item;
	}
	
	<T, Num extends Number> T process(T item, Num number) {
		
		return item;
	}
	
	static void print(Collection<String> collection) {
		for (String s : collection) {
			System.out.println(s);
		}
	}
	
	static boolean find(List<? extends Product> products, Product aProduct) {
		for (Product curProduct : products) {
			if (aProduct.getName().equals(curProduct.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	static <T extends Product> boolean findWithT(List<T> products, T aProduct) {
		for (Product curProduct : products) {
			if (aProduct.getName().equals(curProduct.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	static void copy(List<? extends Product> input, List<? super Product> output) {
		for (Product curProduct : input) {
			output.add(curProduct);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] arguments) {
		
		System.out.println("Java Core Lection 1");
		
		Basket<Fruit> basket = new Basket<Fruit>();
		basket.setElement(new Apple());
		@SuppressWarnings("unused")
		Apple apple = (Apple) basket.getElement();
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		List<String> listStr = new ArrayList<>();
		
//		listStr = list;
		list = listStr;
		
		list.add(8);
//		@SuppressWarnings("unused")
//		String value = listStr.get(0);
		
		@SuppressWarnings({ "rawtypes", "unused" })
        SomeType some = new SomeType();
		@SuppressWarnings("unused")
		List<String> listValue = Arrays.asList("value");
//		some.test(listValue); // ClassCastException
		
		SomeType<String> someStr = new SomeType<>();
		List<String> listStrValue = Arrays.asList("value");
		someStr.test(listStrValue); // ClassCastException
		
		List<String> listString = new ArrayList<>();
//		List<Object> listObjects = listString; // Compilation error
		List<Object> listObjects = new ArrayList<>();
		
		print(listString);
//		print(listObjects); // Compilation error
		
		Camera camera = new Camera();
		Container<Camera> container = new Container<>();
		container.setItem(camera);
		
//		Container<String> strContainer; // Compilation error
//		Container<Product> productContainer; // Compilation error
		
		List<Camera> listCamera = new ArrayList<>();
		find(listCamera, camera);
		
		List<Product> listProduct = new ArrayList<>();
		find(listProduct, camera);
		
		@SuppressWarnings("unused")
		List<Camera> listCamera2 = new ArrayList<>();
		
		copy(listCamera, listProduct);
		copy(listCamera, listObjects);
//		copy(listCamera, listCamera2); // Compilation error
	}
	
}
