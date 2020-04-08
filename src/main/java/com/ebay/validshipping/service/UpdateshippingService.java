package com.ebay.validshipping.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.ebay.validshipping.repository.ShippingRuleRepository;

@Service
public class UpdateshippingService {

	@Autowired
	ShippingRuleRepository shippingProgram;
	

	public void updatePriceRule(PriceRule pr) {

		shippingProgram.updatePriceRule(pr);

	}
	
	public List<PriceRule> getPriceRule() {
		return shippingProgram.getPriceRule();
	}

	public void addSellerRule(SellerRule seller) {

		shippingProgram.addSellerRule(seller);

	}

	public void removeSellerRule(SellerRule seller) {

		shippingProgram.removeSellerRule(seller);

	}

	public List<SellerRule> getSellerRule() {
		return shippingProgram.getSellerRules();
	}

	public void addCategoryRule(CategoryRule category) {

		shippingProgram.addCategoryRule(category);

	}

	public void removeCategoryRule(CategoryRule category) {

		shippingProgram.removeCategoryRule(category);

	}

	public List<CategoryRule> getCategoryRule() {
		return shippingProgram.getCategoryRules();
	}

}
