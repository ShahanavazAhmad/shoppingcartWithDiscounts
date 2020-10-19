package com.shaan.shoppingcart.controller.models;

public class DiscountRule {
	
	private Long discountId;
	
	private String title;
	
	private String customerType;
	
	private double priceBandStart;
	
	private double priceBandEnd;
	
	private double percentageDiscount;
	
	public DiscountRule(Long discountId, String title, String customerType, double priceBandStart, double priceBandEnd,
			double percentageDiscount) {
		this.discountId = discountId;
		this.title = title;
		this.customerType = customerType;
		this.priceBandStart = priceBandStart;
		this.priceBandEnd = priceBandEnd;
		this.percentageDiscount = percentageDiscount;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public double getPriceBandStart() {
		return priceBandStart;
	}

	public void setPriceBandStart(double priceBandStart) {
		this.priceBandStart = priceBandStart;
	}

	public double getPriceBandEnd() {
		return priceBandEnd;
	}

	public void setPriceBandEnd(double priceBandEnd) {
		this.priceBandEnd = priceBandEnd;
	}

	public double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

}
