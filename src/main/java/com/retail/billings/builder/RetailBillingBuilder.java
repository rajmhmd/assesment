package com.retail.billings.builder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.retail.billing.model.Customer;
import com.retail.billing.model.CustomerType;
import com.retail.billing.model.Item;
import com.retail.billing.model.Product;

public class RetailBillingBuilder {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	private RetailBillingBuilder() {
		
	}
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setProdCode("PRCODE1");
		product.setName("HORLICKS");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setProdCode("PRODCODE2");
		product.setName("BOOST");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		
		return new Customer(CustomerType.AFFILIATE, "affiliateCustomer", "AffiliateCustomer1", new DateTime().minusYears(3));	
	}
	
	public static Customer getEmployeeCustomer() {
		
		return new Customer(CustomerType.EMPLOYEE, "employee", "Employee1", new DateTime().minusYears(3));		
	}
	
	public static Customer getCustomerWithMoreThanTwoYearOldRegistration() {
		
		return new Customer(CustomerType.CUSTOMER, "loyaltycustomer", "loyaltyCustomer1", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));		
	}
	
	public static Customer getCustomerWithLessThanTwoYearOldRegistration() {
		
		return new Customer(CustomerType.CUSTOMER, "customer", "customer1", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));		
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
