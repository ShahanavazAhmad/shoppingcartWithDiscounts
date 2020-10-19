package com.shaan.shoppingcart.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.shaan.shoppingcart.controller.DiscountCalculatorController;
import com.shaan.shoppingcart.controller.factories.DiscountCalculatorFactory;
import com.shaan.shoppingcart.controller.models.DiscountInfo;
import com.shaan.shoppingcart.enums.CustomerTypeEnum;
import com.shaan.shoppingcart.exception.InvalidCustomerTypeException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

	@InjectMocks
	DiscountCalculatorController discountCalculatorController;
	
	@Mock
	DiscountCalculatorFactory discountCalculatorFactory;
	
	@Test
	public void testGetDiscountedPriceForGeneralCustomerTypeFor5000CartValue() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.GENERAL.getCode(), 5000)).thenReturn(0d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.GENERAL.getCode(), 5000);
		assertEquals(5000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(5000, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(0, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.GENERAL.getCode(), discountInfo.getDiscountType());
	}
	
	@Test
	public void testGetDiscountedPriceForGeneralCustomerTypeWith15000CartValue() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.GENERAL.getCode(), 15000)).thenReturn(1500d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.GENERAL.getCode(), 15000);
		assertEquals(15000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(13500, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(1500, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.GENERAL.getCode(), discountInfo.getDiscountType());
	}
	
	@Test
	public void testGetDiscountedPriceForGeneralCustomerTypeWith10000CartValue() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.GENERAL.getCode(), 10000)).thenReturn(500d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.GENERAL.getCode(), 10000);
		assertEquals(10000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(9500, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(500, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.GENERAL.getCode(), discountInfo.getDiscountType());
	}
	
	@Test(expected = InvalidCustomerTypeException.class)
	public void testGetDiscountedPriceForInvalidCustomerType() {
		discountCalculatorController.getDiscountedPrice("invalidCustoerType", 50000);
	}
	
	@Test
	public void testGetDiscountedPriceForPremiumCustomerTypeFor4000TotalBill() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.PREMIUM.getCode(), 4000)).thenReturn(400d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.PREMIUM.getCode(), 4000);
		assertEquals(4000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(3600, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(400, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.PREMIUM.getCode(), discountInfo.getDiscountType());
	}
	
	@Test
	public void testGetDiscountedPriceForPremiumCustomerTypeFor8000TotalBill() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.PREMIUM.getCode(), 8000)).thenReturn(1000d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.PREMIUM.getCode(), 8000);
		assertEquals(8000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(7000, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(1000, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.PREMIUM.getCode(), discountInfo.getDiscountType());
	}
	
	@Test
	public void testGetDiscountedPriceForPremiumCustomerTypeFor12000TotalBill() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.PREMIUM.getCode(), 12000)).thenReturn(1800d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.PREMIUM.getCode(), 12000);
		assertEquals(12000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(10200, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(1800, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.PREMIUM.getCode(), discountInfo.getDiscountType());
	}
	
	@Test
	public void testGetDiscountedPriceForPremiumCustomerTypeFor20000TotalBill() {
		when(discountCalculatorFactory.getDiscountedAmount(CustomerTypeEnum.PREMIUM.getCode(), 20000)).thenReturn(4200d);
		DiscountInfo discountInfo = discountCalculatorController.getDiscountedPrice(CustomerTypeEnum.PREMIUM.getCode(), 20000);
		assertEquals(20000, discountInfo.getTotalCartAmount(), .1d);
		assertEquals(15800, discountInfo.getDiscountedAmount(), .1d);
		assertEquals(4200, discountInfo.getTotalDiscount(), .1d);
		assertEquals(CustomerTypeEnum.PREMIUM.getCode(), discountInfo.getDiscountType());
	}
}
