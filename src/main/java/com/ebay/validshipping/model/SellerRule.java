package com.ebay.validshipping.model;

import java.util.List;

public class SellerRule implements Rule {


	
	private String sellerName;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public SellerRule() {
		
	}

	public SellerRule(String sellerName) {
	
		this.sellerName = sellerName;
	}

	@Override
	public String toString() {
		return "SellerRule [sellerName=" + sellerName + "]";
	}
	
	
	
	

}
