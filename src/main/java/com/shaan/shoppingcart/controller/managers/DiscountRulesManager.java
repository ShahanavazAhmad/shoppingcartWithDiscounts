package com.shaan.shoppingcart.controller.managers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shaan.shoppingcart.controller.models.DiscountRule;

@Service
public interface DiscountRulesManager {
	
//	 get the discount rules based upon customer type
	public List<DiscountRule> getDiscountRules(String customerType);
	
	public DiscountRule saveDiscountRule (DiscountRule requestBody);

}
