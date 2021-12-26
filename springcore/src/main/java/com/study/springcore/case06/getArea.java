package com.study.springcore.case06;

public class getArea extends RoundBeanImpl{

	@Override
	public double getRoundArea() {
		
		return r*r*Math.PI;
	}

	@Override
	public void setRadius(double r) {
		this.r = r;
		
	}

	@Override
	public double getRadius() {
		
		return r;
	}

}
