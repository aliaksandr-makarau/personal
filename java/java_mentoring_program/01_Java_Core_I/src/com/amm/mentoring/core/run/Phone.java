package com.amm.mentoring.core.run;

public class Phone extends Product {

	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	protected int deepCompare(Phone p) {
		
		return 0;
	}
	
}
