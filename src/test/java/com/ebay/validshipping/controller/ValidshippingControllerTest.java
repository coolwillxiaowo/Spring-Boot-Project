package com.ebay.validshipping.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class ValidshippingControllerTest {

	private MockMvc mvc;
	
	
	@Autowired
	private WebApplicationContext context;

	@Before
	public void setupMockMvc() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	/*
	@Test
	public void testValidShippingControllerWithMockMvc() throws Exception{
	  
//	  mvc.perform(MockMvcRequestBuilders.get("/api/validshipping").requestAttr("title", "hi").requestAttr("seller", "Walmart").requestAttr("category", 1).requestAttr("price", 10000))
//	    .andExpect(status().isOk());
	  //mvc.perform(get("/api/validshipping").param("title", "Value").param("seller", "Value").param("category", "Value").param("price", "Value")).andExpect(status().is2xxSuccessful()).andExpect(content().string("true"));
		mvc.perform(get("/api/validshipping/{title}/{seller}/{category}/{price}", "hi", "Walmart", 1, 100)).andExpect(status().isOk());

	
	}
	*/

	@Test
	public void TestGetSellerRule() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/api/seller")).andExpect(MockMvcResultMatchers.status().isOk());
//        .andExpect(MockMvcResultMatchers.content().string("abc"));
	}

	@Test
	public void TestGetCategoryRule() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/api/category")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void TestGetPriceRule() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/api/price")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateSellerRuleTest() throws Exception {

		// ObjectMapper is a reusable object
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"sellerName\":\"Walmart\"}";
		// replace the JSON string to a attribute of SellerRule
		SellerRule sr = mapper.readValue(jsonString, SellerRule.class);
		mvc.perform(MockMvcRequestBuilders.post("/api/seller").contentType(MediaType.APPLICATION_JSON_UTF8)
				/*
				 * Use writeValueAsString() method to get the representation of the object's
				 * Json string
				 */
				.content(mapper.writeValueAsString(sr))).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].sellerName").value("Walmart"));
	}

	@Test
	public void updateCategoryRuleTest() throws Exception {

		// ObjectMapper is a reusable object
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"categoryNumber\":1}";
		CategoryRule cr = mapper.readValue(jsonString, CategoryRule.class);
		mvc.perform(MockMvcRequestBuilders.post("/api/category").contentType(MediaType.APPLICATION_JSON_UTF8)
				/*
				 * Use writeValueAsString() method to get the representation of the object's
				 * Json string
				 */
				.content(mapper.writeValueAsString(cr))).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryNumber").value(1));
	}

	@Test
	public void updatePriceRuleTest() throws Exception {

		// ObjectMapper is a reusable object
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"price\":200}";
		// replace the JSON string to a attribute of SellerRule
		PriceRule pr = mapper.readValue(jsonString, PriceRule.class);
		mvc.perform(MockMvcRequestBuilders.put("/api/price").contentType(MediaType.APPLICATION_JSON_UTF8)
				/*
				 * Use writeValueAsString() method to get the representation of the object's
				 * Json string
				 */
				.content(mapper.writeValueAsString(pr))).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(200));
	}

	@Test
	public void removeSellerRuleTest() throws Exception {

		// ObjectMapper is a reusable object
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"sellerName\":\"Amazon\"}";
		// replace the JSON string to a attribute of SellerRule
		SellerRule sr = mapper.readValue(jsonString, SellerRule.class);
		mvc.perform(MockMvcRequestBuilders.delete("/api/seller").contentType(MediaType.APPLICATION_JSON_UTF8)
				/*
				 * Use writeValueAsString() method to get the representation of the object's
				 * Json string
				 */
				.content(mapper.writeValueAsString(sr))).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].sellerName").value("Walmart"));

	}

	@Test
	public void removeCategoryRuleTest() throws Exception {

		// ObjectMapper is a reusable object
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"categoryNumber\":2}";
		CategoryRule cr = mapper.readValue(jsonString, CategoryRule.class);
		mvc.perform(MockMvcRequestBuilders.delete("/api/category").contentType(MediaType.APPLICATION_JSON_UTF8)
				/*
				 * Use writeValueAsString() method to get the representation of the object's
				 * Json string
				 */
				.content(mapper.writeValueAsString(cr))).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].categoryNumber").value(1));
	}
	
	
	
	

}
