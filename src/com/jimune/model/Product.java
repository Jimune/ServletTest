package com.jimune.model;

import com.jimune.Util;

public class Product {

	private String name;
	private String imageUrl;
	private double pricePerUnit;
	private Unit unit;
	
	public Product(String name, double pricePerUnit, String imageUrl) {
		this(name, pricePerUnit, imageUrl, Unit.PIECE);
	}
	
	public Product(String name, double pricePerUnit, String imageUrl, Unit unit) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.imageUrl = imageUrl;
		this.unit = unit;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public double getPrice(int amount) {
		return amount * pricePerUnit;
	}
	
	@Override
	public String toString() {
		return Util.build("Name:",name, "ImageURL:",imageUrl,"Price Per Unit:", pricePerUnit, "Unit:",unit.name());
	}
}
