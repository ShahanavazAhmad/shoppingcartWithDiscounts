package com.shaan.shoppingcart.controller.resources;

import java.util.List;

import com.shaan.shoppingcart.controller.models.DiscountRule;

public class DiscountRulesResource {
	
	List<DiscountRule> discountRules;

	public List<DiscountRule> getDiscountRules() {
		return discountRules;
	}

	public void setDiscountRules(List<DiscountRule> discountRules) {
		this.discountRules = discountRules;
	}

}
