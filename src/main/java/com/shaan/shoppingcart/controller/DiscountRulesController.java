package com.shaan.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shaan.shoppingcart.controller.factories.DiscountRulesResourceFactory;
import com.shaan.shoppingcart.controller.models.DiscountRule;
import com.shaan.shoppingcart.controller.resources.DiscountRulesResource;
import com.shaan.shoppingcart.enums.CustomerTypeEnum;
import com.shaan.shoppingcart.exception.InvalidCustomerTypeException;

@RestController
@RequestMapping(value = "/rest/shoppingcart")
public class DiscountRulesController {

	public static final String INVALID_CUSTOMER_TYPE_EXCEPTION_MSG = "The entered customer type is not valid. Please enter a valid customer type and try again.";
	
	@Autowired
	DiscountRulesResourceFactory discountRulesResourceFactory;

	@RequestMapping(value = "/discounts/{customerType}", method = RequestMethod.GET)
	public DiscountRulesResource getDiscountRules(@PathVariable String customerType) {
		DiscountRulesResource discountRulesResource = new DiscountRulesResource();

		if (CustomerTypeEnum.decode(customerType) != null) {
			discountRulesResource = discountRulesResourceFactory.getDiscountRules(customerType);
		} else {
			throw new InvalidCustomerTypeException(INVALID_CUSTOMER_TYPE_EXCEPTION_MSG);
		}

		return discountRulesResource;
	}

	// BindingResult should be used for validating the requestBody.
	@RequestMapping(value = "/discounts", method = RequestMethod.POST)
	public DiscountRulesResource saveDiscountRules(@RequestBody DiscountRule requestBody) {

		DiscountRulesResource discountRulesResource = new DiscountRulesResource();
		if (CustomerTypeEnum.decode(requestBody.getCustomerType()) != null) {
			discountRulesResource = discountRulesResourceFactory.saveDiscountRule(requestBody);
		} else {
			throw new InvalidCustomerTypeException(INVALID_CUSTOMER_TYPE_EXCEPTION_MSG);
		}
		return discountRulesResource;
	}

}
