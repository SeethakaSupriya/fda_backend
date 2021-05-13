package com.cg.fda.repository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.FoodCart;

@RunWith(SpringRunner.class)
@DataJpaTest


public class FoodCartRepositoryTest {
	@Autowired
	private FoodCartRepository foodcartRepository;
	@Test
	void testFindByFoodCartId() {
		FoodCart foodcart=new FoodCart();
		//product.setProductId(4);
		foodcart.setFoodCartId(1);
		foodcart.setFoodItemName("Biryani");
		foodcart.setFoodItemQuantity("2");
		foodcart.setFoodItemPrice(300);
		foodcartRepository.save(foodcart);
		int foodcartId=foodcart.getFoodCartId();
		Assert.assertNotNull(foodcartRepository.findByFoodCartId(foodcartId));
	}

}