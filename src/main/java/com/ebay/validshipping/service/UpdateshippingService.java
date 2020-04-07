package com.ebay.validshipping.service;

import java.util.List;

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

	public void updatePriceRule(double price) {

		PriceRule pr = shippingProgram.getPriceRule();
		pr.setPrice(price);

	}

	public void updateSellerRule(String seller) {

		SellerRule sr = shippingProgram.getSellerRule();
		List<String> sellers = sr.getSeller();
		if (!sellers.contains(seller)) {
			sellers.add(seller);
		}

	}

	public void removeSellerRule(String seller) {
		
		SellerRule sr = shippingProgram.getSellerRule();
		List<String> sellers = sr.getSeller();
		if (sellers.contains(seller)) {
			sellers.remove(seller);
		}

	}

	public void updateCategoryRule(int category) {
		CategoryRule cr = shippingProgram.getCategoryRule();
		List<Integer> categories = cr.getCategories();
		if (!categories.contains(category)) {
			categories.add(category);
		}

	}

	public void removeCategoryRule(Integer category) {
		CategoryRule cr = shippingProgram.getCategoryRule();
		List<Integer> categories = cr.getCategories();
		if (categories.contains(category)) {
			categories.remove(category);
		}
	}

}
