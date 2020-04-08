package com.ebay.validshipping.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.springframework.stereotype.Repository;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;

@Repository
public class ShippingRuleRepository {

	
	private List<SellerRule> sellerRuleDB = new ArrayList<>();
	private Stack<PriceRule> priceRuleDB = new Stack<>();
	private List<CategoryRule> categoryRuleDB = new ArrayList<>();

	public ShippingRuleRepository() {
		
		sellerRuleDB.add(new SellerRule("Walmart"));
		priceRuleDB.push(new PriceRule(100));
		categoryRuleDB.add(new CategoryRule(1));


	}
	
	public List<SellerRule> getSellerRules() {
//		List<SellerRule> list = new ArrayList<>();
//		for (SellerRule sr : sellerRuleDB) {
//			//System.out.println(sr);
//			list.add(sr);
//		}
		return this.sellerRuleDB;
	}
	
	public List<CategoryRule> getCategoryRules() {
//		List<CategoryRule> list = new ArrayList<>();
//		for (CategoryRule cr : categoryRuleDB) {
//			list.add(cr);
//		}
		return this.categoryRuleDB;
	}
	
	public List<PriceRule> getPriceRule() {
		List<PriceRule> list = new ArrayList<>();
		PriceRule pr = priceRuleDB.peek();
		list.add(pr);
		return list;
	}
	
	public void addSellerRule(SellerRule sr) {
		boolean flag = false;
		for (SellerRule s : sellerRuleDB) {
			if (s.getSellerName().equals(sr.getSellerName())) {
				flag = true;
			}
		}
		if (flag == false) {
			this.sellerRuleDB.add(sr);
		}
		
		
	}
	
	public void removeSellerRule(SellerRule sr) {
		
		for (SellerRule s : sellerRuleDB) {
			if (s.getSellerName().equals(sr.getSellerName())) {
				sellerRuleDB.remove(s);
			}
		}
	}
	
	public void updatePriceRule(PriceRule pr) {
		this.priceRuleDB.pop();
		this.priceRuleDB.push(pr);
		
	}
	
	public void addCategoryRule(CategoryRule cr) {
		boolean flag = false;
		for (CategoryRule c : categoryRuleDB) {
			if (c.getCategoryNumber() == cr.getCategoryNumber()) {
				flag = true;
			}
		}
		if (flag == false) {
			this.categoryRuleDB.add(cr);
		}
	}
	
	public void removeCategoryRule(CategoryRule cr) {
		for (CategoryRule c : categoryRuleDB) {
			if (c.getCategoryNumber() == cr.getCategoryNumber()) {
				categoryRuleDB.remove(c);
			}
		}
	}
	
	


	
	

}
