package com.ebay.validshipping.model;

import java.util.List;

public class CategoryRule implements Rule {

	private List<Integer> categories;

	public CategoryRule(List<Integer> categories) {

		this.categories = categories;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}


	@Override
	public String toString() {
		return "CategoryRule [categories=" + categories + "]";
	}

}
