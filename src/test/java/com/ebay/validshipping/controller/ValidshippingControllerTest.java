package com.ebay.validshipping.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ebay.validshipping.model.SellerRule;

public class ValidshippingControllerTest extends AbstractTest{
	
	@Test
	public void TestGetSellerRule() throws Exception {
	   String uri = "localhost:8080/api/seller";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	   
//	   int status = mvcResult.getResponse().getStatus();
//	   assertEquals(200, status);
//	   String content = mvcResult.getResponse().getContentAsString();
//	   SellerRule[] productlist = (SellerRule[]) super.mapFromJson(content, SellerRule[].class);
//	   assertTrue(productlist.length > 0);
	}

}
