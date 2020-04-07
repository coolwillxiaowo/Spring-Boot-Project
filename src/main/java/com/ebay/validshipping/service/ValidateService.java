package com.ebay.validshipping.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.ebay.validshipping.repository.ShippingRuleRepository;

@Service
public class ValidateService {

	@Autowired
	ShippingRuleRepository shippingProgram;

	public boolean checkSeller(String seller) {
		SellerRule sr = shippingProgram.getSellerRule();
		if (sr.getSeller().contains(seller)) {
			return true;
		}
		return false;
		
	}

	public boolean checkCategory(int category) {

		CategoryRule cr = shippingProgram.getCategoryRule();
		if (cr.getCategories().contains(category)) {
			return true;
		}
		return false;

	
	}

	public boolean checkPrice(double price) {
		PriceRule pr = shippingProgram.getPriceRule();
		return pr.isValid(price);


	}

}
