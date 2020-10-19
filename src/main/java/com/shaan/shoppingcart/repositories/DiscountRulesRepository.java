package com.shaan.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaan.shoppingcart.entities.DiscountRulesEntity;

@Repository
public interface DiscountRulesRepository extends JpaRepository<DiscountRulesEntity, Long>{
	
	public List<DiscountRulesEntity> findByCustomerType(final String customerType);
}
