package com.ebay.validshipping.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import com.ebay.validshipping.model.CategoryRule;
import com.ebay.validshipping.model.PriceRule;
import com.ebay.validshipping.model.SellerRule;
import com.ebay.validshipping.repository.ShippingRuleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateshippingServiceTest {
	
	@InjectMocks
	private UpdateshippingService updateShippingService;
	
	@Mock
	ShippingRuleRepository shippingProgram;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testUpdatePriceRule() {
		
		PriceRule pr = new PriceRule();
		pr.setPrice(10);
		//test
		updateShippingService.updatePriceRule(pr);
		//verfity this behavior happens at least once in the shippingProgram
		verify(shippingProgram, times(1)).updatePriceRule(pr);
		
	}
	
	@Test
	public void testGetPriceRule() {
		List<PriceRule> list = new ArrayList<>();
		PriceRule pr1 = new PriceRule(10);
		list.add(pr1);
		when(shippingProgram.getPriceRule()).thenReturn(list);
		//test
		List<PriceRule> pList = updateShippingService.getPriceRule();
		assertEquals(1, pList.size());
		verify(shippingProgram, times(1)).getPriceRule();
	}
	
	@Test
	public void testAddSellerRule() {
		
		SellerRule sr = new SellerRule();
		sr.setSellerName("Amazon");
		//test
		updateShippingService.addSellerRule(sr);
		//verfity this behavior happens at least once in the shippingProgram
		verify(shippingProgram, times(1)).addSellerRule(sr);
		
	}
	
	@Test
	public void testRemoveSellerRule() {
		
		SellerRule sr = new SellerRule();
		sr.setSellerName("Amazon");
		//test
		updateShippingService.removeSellerRule(sr);
		verify(shippingProgram, times(1)).removeSellerRule(sr);
		
	}
	
	@Test
	public void testGetSellerRule() {
		List<SellerRule> list = new ArrayList<>();
		SellerRule sr1 = new SellerRule("Walmart");
		SellerRule sr2 = new SellerRule("Amazon");
		list.add(sr1);
		list.add(sr2);
		when(shippingProgram.getSellerRules()).thenReturn(list);
		//test
		List<SellerRule> sellerList = updateShippingService.getSellerRule();
		assertEquals(2, sellerList.size());
		verify(shippingProgram, times(1)).getSellerRules();
	}
	
	@Test
	public void testGetCategoryRule() {
		List<CategoryRule> list = new ArrayList<>();
		CategoryRule cr1 = new CategoryRule(1);
		CategoryRule cr2 = new CategoryRule(2);
		CategoryRule cr3 = new CategoryRule(3);
		list.add(cr1);
		list.add(cr2);
		list.add(cr3);
		when(shippingProgram.getCategoryRules()).thenReturn(list);
		
		//test
		List<CategoryRule> categoryList = updateShippingService.getCategoryRule();
		assertEquals(3, categoryList.size());
		verify(shippingProgram, times(1)).getCategoryRules();
	}
	
	@Test
	public void testAddCategoryRule() {
		
		CategoryRule cr = new CategoryRule();
		cr.setCategoryNumber(2);
		//test
		updateShippingService.addCategoryRule(cr);
		verify(shippingProgram, times(1)).addCategoryRule(cr);
		
	}
	
	@Test
	public void testRemoveCategoryRule() {
		
		CategoryRule cr = new CategoryRule();
		cr.setCategoryNumber(2);
		//test
		updateShippingService.removeCategoryRule(cr);
		verify(shippingProgram, times(1)).removeCategoryRule(cr);
		
	}
	
	
	
	
	

}
