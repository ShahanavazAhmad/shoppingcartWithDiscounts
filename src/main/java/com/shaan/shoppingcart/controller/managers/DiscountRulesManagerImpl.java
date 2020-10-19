package com.shaan.shoppingcart.controller.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shaan.shoppingcart.controller.entities.DiscountRulesEntity;
import com.shaan.shoppingcart.controller.models.DiscountRule;
import com.shaan.shoppingcart.controller.models.repositories.DiscountRulesRepository;

@Component
public class DiscountRulesManagerImpl implements DiscountRulesManager {

	@Autowired
	DiscountRulesRepository discountRulesRepository;

	@Override
	public List<DiscountRule> getDiscountRules(String customerType) {
		List<DiscountRulesEntity> discountRulesEntitities = discountRulesRepository.findByCustomerType(customerType);

		List<DiscountRule> discountRules = convertDiscountEntityToModel(discountRulesEntitities);
		return discountRules;
	}

	private List<DiscountRule> convertDiscountEntityToModel(List<DiscountRulesEntity> discountRulesEntitities) {
		List<DiscountRule> discountRules = new ArrayList<DiscountRule>();
		for (DiscountRulesEntity entity : discountRulesEntitities) {
			DiscountRule discountRule = new DiscountRule(entity.getDiscountId(), entity.getTitle(),
					entity.getCustomerType(), entity.getPriceBandStart(), entity.getPriceBandEnd(),
					entity.getPercentageDiscount());
			discountRules.add(discountRule);
		}
		return discountRules;
	}

	@Override
	public DiscountRule saveDiscountRule(DiscountRule requestBody) {
		DiscountRulesEntity entity = new DiscountRulesEntity(requestBody.getTitle(), requestBody.getCustomerType(),
				requestBody.getPriceBandStart(), requestBody.getPriceBandEnd(), requestBody.getPercentageDiscount());
		DiscountRulesEntity savedEntity = discountRulesRepository.save(entity);
		DiscountRule discountRule = new DiscountRule(savedEntity.getDiscountId(), savedEntity.getTitle(),
				savedEntity.getCustomerType(), savedEntity.getPriceBandStart(), savedEntity.getPriceBandEnd(),
				savedEntity.getPercentageDiscount());
		return discountRule;
	}

}
