package com.ebay.validshipping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@Autowired
	ShippingRuleRepository shippingProgram;

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
	
	@RequestMapping(value = "/seller", method = RequestMethod.GET)
	public @ResponseBody SellerRule getSellerRule() throws Exception {

		System.out.println(shippingProgram.getSellerRule());
		return shippingProgram.getSellerRule();
		
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public @ResponseBody CategoryRule getCategoryRule() throws Exception {

		System.out.println(shippingProgram.getCategoryRule());
		return shippingProgram.getCategoryRule();
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public @ResponseBody PriceRule getPriceRule() throws Exception {

		System.out.println(shippingProgram.getPriceRule());
		return shippingProgram.getPriceRule();
	}

	@RequestMapping(value = "/seller", method = RequestMethod.POST, consumes = "text/plain", produces = "application/json")
	public @ResponseBody SellerRule updateSellerRule(@RequestBody String seller) throws Exception {

		updateService.updateSellerRule(seller);
		System.out.println(shippingProgram.getSellerRule());
		return shippingProgram.getSellerRule();
		// return new ArrayList<String>(shippingProgram.getSellerRule().getSeller());

	}

	@RequestMapping(value = "/category", method = RequestMethod.POST, consumes = "text/plain", produces = "application/json")
	public @ResponseBody CategoryRule updateCategoryRule(@RequestBody String categoryStr) throws Exception {

		Integer category = Integer.valueOf(categoryStr);
		updateService.updateCategoryRule(category);
		System.out.println(shippingProgram.getCategoryRule());
		return shippingProgram.getCategoryRule();
	}

	@RequestMapping(value = "/price", method = RequestMethod.PUT, consumes = "text/plain", produces = "application/json")
	public @ResponseBody PriceRule updatePriceRule(@RequestBody String priceStr) throws Exception {
		Double price = Double.parseDouble(priceStr);
		updateService.updatePriceRule(price);
		System.out.println(shippingProgram.getPriceRule());
		return shippingProgram.getPriceRule();
	}

	@RequestMapping(value = "/seller", method = RequestMethod.DELETE, consumes = "text/plain", produces = "application/json")
	public @ResponseBody SellerRule removeSellerRule(@RequestBody String seller) throws Exception {

		updateService.removeSellerRule(seller);
		;
		System.out.println(shippingProgram.getSellerRule());
		return shippingProgram.getSellerRule();
		// return new ArrayList<String>(shippingProgram.getSellerRule().getSeller());

	}

	@RequestMapping(value = "/category", method = RequestMethod.DELETE, consumes = "text/plain", produces = "application/json")
	public @ResponseBody CategoryRule removeCategoryRule(@RequestBody String categoryStr) throws Exception {

		Integer category = Integer.valueOf(categoryStr);
		updateService.removeCategoryRule(category);
		;
		System.out.println(shippingProgram.getCategoryRule());
		return shippingProgram.getCategoryRule();
	}

}
