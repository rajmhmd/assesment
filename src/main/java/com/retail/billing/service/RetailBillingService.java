package com.retail.billing.service;

import java.util.List;

import com.retail.billing.model.Customer;
import com.retail.billing.model.Item;

/**
 * 
 * @author Raj Mohamad
 *
 */
public interface RetailBillingService {
	
	double calculateNetPayableAmount(Customer customer, List<Item> items);

}
