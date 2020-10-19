package com.shaan.shoppingcart.controller.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discount_rules")
public class DiscountRulesEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "discountId")
	private Long discountId;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "customerType")
	private String customerType;
	
	@Column(name = "priceBandStart")
	private double priceBandStart;
	
	@Column(name = "priceBandEnd")
	private double priceBandEnd;
	
	@Column(name = "percentageDiscount")
	private double percentageDiscount;
	
	public DiscountRulesEntity(String title, String customerType, double priceBandStart,
			double priceBandEnd, double percentageDiscount) {
//		this.discountId = discountId;
		this.title = title;
		this.customerType = customerType;
		this.priceBandStart = priceBandStart;
		this.priceBandEnd = priceBandEnd;
		this.percentageDiscount = percentageDiscount;
	}
	

	public DiscountRulesEntity() {
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
		result = prime * result + ((discountId == null) ? 0 : discountId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentageDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceBandEnd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceBandStart);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscountRulesEntity other = (DiscountRulesEntity) obj;
		if (customerType == null) {
			if (other.customerType != null)
				return false;
		} else if (!customerType.equals(other.customerType))
			return false;
		if (discountId == null) {
			if (other.discountId != null)
				return false;
		} else if (!discountId.equals(other.discountId))
			return false;
		if (Double.doubleToLongBits(percentageDiscount) != Double.doubleToLongBits(other.percentageDiscount))
			return false;
		if (Double.doubleToLongBits(priceBandEnd) != Double.doubleToLongBits(other.priceBandEnd))
			return false;
		if (Double.doubleToLongBits(priceBandStart) != Double.doubleToLongBits(other.priceBandStart))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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
