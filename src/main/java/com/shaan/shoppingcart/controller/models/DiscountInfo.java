package com.shaan.shoppingcart.controller.models;

public class DiscountInfo {
	
	private double totalCartAmount;
	
	private double discountedAmount;
	
	private double totalDiscount;
	
	private String discountType;

	public double getTotalCartAmount() {
		return totalCartAmount;
	}

	public void setTotalCartAmount(double totalCartAmount) {
		this.totalCartAmount = totalCartAmount;
	}

	public double getDiscountedAmount() {
		return discountedAmount;
	}

	public void setDiscountedAmount(double discountedAmount) {
		this.discountedAmount = discountedAmount;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	
	

}
