package com.amm.mentoring.core.run;

public abstract class Product implements Comparable<Product> {

	private String name;
	private double price;
	
//	protected abstract int deepCompare(T p);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Product p) {
//		return deepCompare(p);
		return 0;
	}
}
