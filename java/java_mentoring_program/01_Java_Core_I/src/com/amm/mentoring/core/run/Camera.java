package com.amm.mentoring.core.run;

import java.io.Serializable;

public class Camera extends Product implements Serializable {

	private static final long serialVersionUID = -92867226939424888L;

	private double pixel;

	public double getPixel() {
		return pixel;
	}

	public void setPixel(double pixel) {
		this.pixel = pixel;
	}

	protected int deepCompare(Camera p) {
		return 0;
	}
	
}
