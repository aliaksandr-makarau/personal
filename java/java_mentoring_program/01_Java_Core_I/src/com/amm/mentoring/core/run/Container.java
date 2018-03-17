package com.amm.mentoring.core.run;

import java.io.Serializable;

public class Container<T extends Product & Serializable> {

	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
}
