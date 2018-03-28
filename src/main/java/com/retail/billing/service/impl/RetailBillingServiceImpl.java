package com.retail.billing.service.impl;

import java.util.List;

import com.retail.billing.model.Customer;
import com.retail.billing.model.CustomerType;
import com.retail.billing.model.Item;
import com.retail.billing.service.RetailBillingService;

/**
 * 
 * @author Raj Mohamad
 *
 */
public class RetailBillingServiceImpl implements RetailBillingService {

	private static final int DISCOUNT_PER_HUNDRED = 5;

	public double calculateNetPayableAmount(Customer customer, List<Item> items) {
		double totalDiscountedPrice = 0;
		double discountPercentage = getDiscountPercentageForCustomer(customer);
		for(Item item:items) {
			totalDiscountedPrice = totalDiscountedPrice + item.getDiscountedPrice(discountPercentage);
		}
		 
		return Math.round(totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice));
	}


	private double getDiscountPercentageForCustomer(Customer customer) {
		CustomerType customerType = customer.getCustomerType();
		if(customerType == CustomerType.AFFILIATE || customerType == CustomerType.EMPLOYEE || customer.isAvailableForLoyaltyDiscount()) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}
	
	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}
}
