package com.retail.billing.servicetest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.retail.billing.model.Customer;
import com.retail.billing.model.Item;
import com.retail.billing.service.RetailBillingService;
import com.retail.billing.service.impl.RetailBillingServiceImpl;
import com.retail.billings.builder.RetailBillingBuilder;


/**
 * 
 * @author Raj Mohamad
 *
 */
public class BillCalculatorServiceTest {
	
	private RetailBillingService billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billCalculatorService = new RetailBillingServiceImpl();
		items = RetailBillingBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void calculateBillForDiscountEligibleCustomer() {
		Customer customer = RetailBillingBuilder.getCustomerWithMoreThanTwoYearOldRegistration();		
		Assert.assertEquals(761.00, billCalculatorService.calculateNetPayableAmount(customer, items), 0);
	}
	
	@Test
	public void calculateBillForNonEligibleCustomer() {
		Customer customer = RetailBillingBuilder.getCustomerWithLessThanTwoYearOldRegistration();		
		Assert.assertEquals(790.00, billCalculatorService.calculateNetPayableAmount(customer, items), 0);
	}
	
	@Test
	public void calculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = RetailBillingBuilder.getAffiliateCustomer();		
		Assert.assertEquals(737.00, billCalculatorService.calculateNetPayableAmount(affiliateCustomer, items), 0);
	}
	
	@Test
	public void calculateBillForEmployeeCustomer() {
		Customer employeeCustomer = RetailBillingBuilder.getEmployeeCustomer();		
		Assert.assertEquals(626.00, billCalculatorService.calculateNetPayableAmount(employeeCustomer, items), 0);
	}
}
