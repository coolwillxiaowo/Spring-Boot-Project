package com.ebay.validshipping.model;

import java.util.List;

public class SellerRule implements Rule {

	private List<String> seller;

	public SellerRule(List<String> seller) {

		this.seller = seller;
	}

	public List<String> getSeller() {
		return seller;
	}

	public void setSeller(List<String> seller) {
		this.seller = seller;
	}

	public boolean isValid(String seller) {
		if (seller.contains(seller)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "SellerRule [seller=" + seller + "]";
	}

}
