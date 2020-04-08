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

	//private PriceRule priceRule;
	private CategoryRule categoryRule;
	private SellerRule sellerRule;
	
	private Set<SellerRule> sellerRuleDB = new HashSet<>();
	private Stack<PriceRule> priceRuleDB = new Stack<>();
	private Set<CategoryRule> categoryRuleDB = new HashSet<>();

	public ShippingRuleRepository() {
		
		sellerRuleDB.add(new SellerRule("Walmart"));
		priceRuleDB.push(new PriceRule(100));
		categoryRuleDB.add(new CategoryRule(1));


	}
	
	public List<SellerRule> getSellerRules() {
		List<SellerRule> list = new ArrayList<>();
		for (SellerRule sr : sellerRuleDB) {
			list.add(sr);
		}
		return list;
	}
	
	public List<CategoryRule> getCategoryRules() {
		List<CategoryRule> list = new ArrayList<>();
		for (CategoryRule cr : categoryRuleDB) {
			list.add(cr);
		}
		return list;
	}
	
	public List<PriceRule> getPriceRule() {
		List<PriceRule> list = new ArrayList<>();
		PriceRule pr = priceRuleDB.peek();
		list.add(pr);
		return list;
	}
	
	public void addSellerRule(SellerRule sr) {
		this.sellerRuleDB.add(sr);
	}
	
	public void removeSellerRule(SellerRule sr) {
		this.sellerRuleDB.remove(sr);
	}
	
	public void updatePriceRule(PriceRule pr) {
		this.priceRuleDB.pop();
		this.priceRuleDB.push(pr);
		
	}
	
	public void addCategoryRule(CategoryRule cr) {
		this.categoryRuleDB.add(cr);
	}
	
	public void removeCategoryRule(CategoryRule cr) {
		this.categoryRuleDB.remove(cr);
	}
	
	


	
	

}
