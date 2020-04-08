package com.ebay.validshipping.service;

import java.util.List;

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
		List<SellerRule> list = shippingProgram.getSellerRules();
		for (SellerRule sr : list) {
			if (sr.getSellerName().equals(seller)) {
				return true;
			}
		}
		return false;
		
	}

	public boolean checkCategory(int category) {

		List<CategoryRule> list = shippingProgram.getCategoryRules();
		for (CategoryRule cr : list) {
			if (cr.getCategoryNumber() == category) {
				return true;
			}
		}
		return false;

	
	}

	public boolean checkPrice(double pr) {
		List<PriceRule> list = shippingProgram.getPriceRule();
		for (PriceRule p : list) {
			if (p.getPrice() <= pr) {
				return true;
			}
		}
		return false;


	}

}
