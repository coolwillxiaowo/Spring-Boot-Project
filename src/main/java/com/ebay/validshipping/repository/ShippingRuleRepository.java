package com.ebay.validshipping.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;

@Repository
public class ShippingRuleRepository {

	private PriceRule priceRule;
	private CategoryRule categoryRule;
	private SellerRule sellerRule;

	public ShippingRuleRepository() {
		//this is only example for deafult value
		priceRule = new PriceRule(1000);
		List<Integer> tmp = new ArrayList<>();
		tmp.add(1);
		List<String> tmp1 = new ArrayList<>();
		tmp1.add("Walmart");
		categoryRule = new CategoryRule(tmp);
		sellerRule = new SellerRule(tmp1);

	}

//only offer get not set

	public PriceRule getPriceRule() {
		return priceRule;
	}

	public CategoryRule getCategoryRule() {
		return categoryRule;
	}

	public SellerRule getSellerRule() {
		return sellerRule;
	}

}
