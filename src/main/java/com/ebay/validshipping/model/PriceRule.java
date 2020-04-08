package com.ebay.validshipping.model;

public class PriceRule implements Rule {

	private double price;
	
	public PriceRule() {
		
	}

	public PriceRule(double price) {

		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceRule [price=" + price + "]";
	}

	public boolean isValid(double price) {
		return price >= this.price;
	}

}
