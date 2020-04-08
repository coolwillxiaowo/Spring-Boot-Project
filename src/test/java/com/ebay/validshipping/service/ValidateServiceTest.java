package com.ebay.validshipping.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.ebay.validshipping.repository.ShippingRuleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateServiceTest {
	
	@InjectMocks
	private ValidateService validateService;
	
	@Mock
	ShippingRuleRepository shippingProgram;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testCheckSeller() {
		
		String seller = "Walmart";
		
		//test
		validateService.checkSeller(seller);
		//verfity this behavior happens at least once in the shippingProgram
		verify(shippingProgram, times(1)).getSellerRules();
		
	}
	
	@Test
	public void testCheckCategory() {
		
		int category = 1;
		
		//test
		validateService.checkCategory(category);
		//verfity this behavior happens at least once in the shippingProgram
		verify(shippingProgram, times(1)).getCategoryRules();
		
	}
	
	@Test
	public void testCheckPrice() {
		
		double price = 12.2;
		
		//test
		validateService.checkPrice(price);
		//verfity this behavior happens at least once in the shippingProgram
		verify(shippingProgram, times(1)).getPriceRule();
		
	}

}
