package com.shaan.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shaan.shoppingcart.controller.factories.DiscountCalculatorFactory;
import com.shaan.shoppingcart.controller.models.DiscountInfo;
import com.shaan.shoppingcart.enums.CustomerTypeEnum;
import com.shaan.shoppingcart.exception.InvalidCustomerTypeException;

@RestController
@RequestMapping(value = "/rest/shoppingcart")
public class DiscountCalculatorController {

	@Autowired
	DiscountCalculatorFactory discountCalculatorFactory;

	@RequestMapping(value = "/calculateDiscountedPrice/{customerType}/{totalCartAmount}", method = RequestMethod.GET)
	public DiscountInfo getDiscountedPrice(@PathVariable final String customerType,
			@PathVariable final double totalCartAmount) {

		double totalDiscount = 0;
		DiscountInfo discountInfo = new DiscountInfo();
		if (totalCartAmount > 0 && CustomerTypeEnum.decode(customerType) != null) {
			totalDiscount = discountCalculatorFactory.getDiscountedAmount(customerType, totalCartAmount);

			discountInfo.setTotalCartAmount(totalCartAmount);
			discountInfo.setDiscountedAmount(totalCartAmount - totalDiscount);
			discountInfo.setTotalDiscount(totalDiscount);
			discountInfo.setDiscountType(customerType);
		} else {
			throw new InvalidCustomerTypeException(DiscountRulesController.INVALID_CUSTOMER_TYPE_EXCEPTION_MSG);
		}
		return discountInfo;

	}

}
