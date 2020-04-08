package com.ebay.validshipping.model;

import java.util.List;

public class CategoryRule implements Rule {

	
	private int categoryNumber;
	
	public CategoryRule() {
		
	}

	public CategoryRule(int categoryNumber) {

		this.categoryNumber = categoryNumber;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Override
	public String toString() {
		return "CategoryRule [categoryNumber=" + categoryNumber + "]";
	}
	

}
