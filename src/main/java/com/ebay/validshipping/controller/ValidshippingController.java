package com.ebay.validshipping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.ebay.validshipping.repository.ShippingRuleRepository;
import com.ebay.validshipping.service.UpdateshippingService;
import com.ebay.validshipping.service.ValidateService;

@Controller
@RequestMapping("/api")
public class ValidshippingController {

	@Autowired
	ValidateService validateService;

	@Autowired
	UpdateshippingService updateService;

	@RequestMapping(value = "/validshipping", method = RequestMethod.GET)
	public @ResponseBody Boolean isvalid(@RequestParam("title") String title, @RequestParam("seller") String seller,
			@RequestParam("category") Integer category, @RequestParam("price") double price) {
		if (title == null) {
			return false;
		}
		if (validateService.checkSeller(seller) && validateService.checkPrice(price)
				&& validateService.checkCategory(category)) {
			return true;
		}
		return false;
	}
	/*
	@RequestMapping(value = "/validshipping", method = RequestMethod.GET)
	public @ResponseBody Boolean isvalid(@PathVariable("title") String title, @PathVariable("seller") String seller,
			@PathVariable("category") Integer category, @PathVariable("price") double price) {
		if (title == null) {
			return false;
		}
		if (validateService.checkSeller(seller) && validateService.checkPrice(price)
				&& validateService.checkCategory(category)) {
			return true;
		}
		return false;
	}
	*/
	@RequestMapping(value = "/seller", method = RequestMethod.GET)
	public @ResponseBody List<SellerRule> getSellerRule() throws Exception {

		return updateService.getSellerRule();
		
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public @ResponseBody List<CategoryRule> getCategoryRule() throws Exception {

		return updateService.getCategoryRule();
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public @ResponseBody List<PriceRule> getPriceRule() throws Exception {

		return updateService.getPriceRule();
	}

	@RequestMapping(value = "/seller", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<SellerRule> updateSellerRule(@RequestBody SellerRule seller) throws Exception {

		updateService.addSellerRule(seller);
		return updateService.getSellerRule();

	}

	@RequestMapping(value = "/category", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<CategoryRule> updateCategoryRule(@RequestBody CategoryRule category) throws Exception {

		updateService.addCategoryRule(category);
		return updateService.getCategoryRule();
	}

	@RequestMapping(value = "/price", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<PriceRule> updatePriceRule(@RequestBody PriceRule price) throws Exception {

		updateService.updatePriceRule(price);
		return updateService.getPriceRule();
	}

	@RequestMapping(value = "/seller", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<SellerRule> removeSellerRule(@RequestBody SellerRule seller) throws Exception {

		updateService.removeSellerRule(seller);
		return updateService.getSellerRule();
	}

	@RequestMapping(value = "/category", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public @ResponseBody List<CategoryRule> removeCategoryRule(@RequestBody CategoryRule category) throws Exception {

		updateService.removeCategoryRule(category);
		return updateService.getCategoryRule();
	}

}
