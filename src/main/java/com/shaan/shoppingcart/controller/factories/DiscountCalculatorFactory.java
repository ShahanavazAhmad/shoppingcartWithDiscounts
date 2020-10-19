package com.shaan.shoppingcart.controller.factories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaan.shoppingcart.controller.managers.DiscountRulesManager;
import com.shaan.shoppingcart.controller.models.DiscountRule;

@Service
public class DiscountCalculatorFactory {

	@Autowired
	DiscountRulesManager discountRulesManager;

	public double getDiscountedAmount(final String customerType, final double totalCartAmount) {
		List<DiscountRule> discountRules = discountRulesManager.getDiscountRules(customerType);

		double discount = 0;
		double remainingCartPrice = totalCartAmount;
		for (DiscountRule discountRule : discountRules) {
			double discountSlabUpperLimit = discountRule.getPriceBandEnd();
			double discountSlabLowerLimit = discountRule.getPriceBandStart();
			double discountPercentage = discountRule.getPercentageDiscount();
			if ((discountSlabUpperLimit - discountSlabLowerLimit +1) <= remainingCartPrice) {
				remainingCartPrice = remainingCartPrice - (discountSlabUpperLimit - discountSlabLowerLimit) -1;
				discount = discount + ((discountSlabUpperLimit - discountSlabLowerLimit + 1) * discountPercentage) / 100;
			} else {
				discount = discount + (remainingCartPrice * discountPercentage) / 100;
				break;
			}
		}

		return discount;
	}
}
