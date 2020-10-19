package com.shaan.shoppingcart.factories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaan.shoppingcart.managers.DiscountRulesManager;
import com.shaan.shoppingcart.models.DiscountRule;
import com.shaan.shoppingcart.resources.DiscountRulesResource;

@Service
public class DiscountRulesResourceFactory {

	@Autowired
	DiscountRulesManager discountRulesManager;

	public DiscountRulesResource getDiscountRules(String customerType) {

		DiscountRulesResource discountRulesResource = new DiscountRulesResource();
		List<DiscountRule> discountRules = discountRulesManager.getDiscountRules(customerType);
		discountRulesResource.setDiscountRules(discountRules);

		return discountRulesResource;

	}

	public DiscountRulesResource saveDiscountRule(DiscountRule requestBody) {

		DiscountRulesResource discountRulesResource = new DiscountRulesResource();
		List<DiscountRule> discountRules = new ArrayList<>();
		DiscountRule discountRule = discountRulesManager.saveDiscountRule(requestBody);
		discountRules.add(discountRule);
		discountRulesResource.setDiscountRules(discountRules);

		return discountRulesResource;

	}

}
