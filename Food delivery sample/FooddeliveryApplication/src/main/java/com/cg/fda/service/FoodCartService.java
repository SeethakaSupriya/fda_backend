package com.cg.fda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fda.exception.FoodCartIdNotFoundException;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.repository.FoodCartRepository;



/**
 *  desc: cart service is implemented for the methods  
 *       mentioned in the cart service interface
 * @author Supriya
 *
 */
@Service
public class FoodCartService implements FoodCartServiceImpl{
	/**
	 * autowired the  cart repository 
	 */
	@Autowired
	private FoodCartRepository foodcartRepository;

	/**
	 * overriden the add cart method
	 */
	@Override
	public FoodCart addFoodCarts(FoodCart foodcart) {
		
		return foodcartRepository.save(foodcart);
	}	

	/**
	 * overriden the update cart method
	 */
	@Override
	  public FoodCart updateFoodCart(FoodCart foodcart, int foodCartId) throws FoodCartIdNotFoundException { 
		FoodCart requiredFoodCart=foodcartRepository.findByFoodCartId(foodCartId);
		  if(requiredFoodCart!=null) {
		
		requiredFoodCart.setFoodItemQuantity(foodcart.getFoodItemQuantity());
		 requiredFoodCart.setFoodItemPrice(foodcart.getFoodItemPrice());
		 return foodcartRepository.save(requiredFoodCart);
		 
		  
		  }
		  else {
				throw new FoodCartIdNotFoundException("Unable to get the cart details. ");
			}
		  }	 
	/**
	 * overriden the view cart by id method
	 */
	@Override
	public FoodCart viewFoodCartByFoodCartId(int foodCartId) throws FoodCartIdNotFoundException {
		FoodCart foodcart= foodcartRepository.findByFoodCartId(foodCartId);
		if(foodcart!=null) {
			
		return foodcart;
		}
		else {
			throw new FoodCartIdNotFoundException("FoodCart with id "+foodCartId+" is not present.");
		}
	}
/**
 * overriden the delete cart method
 */
	@Override
	
	public FoodCart deleteFoodCart(int foodCartId) {
		FoodCart foodcart=foodcartRepository.findByFoodCartId(foodCartId);
		foodcartRepository.deleteById(foodCartId);
		
				return foodcart;
	}


	/**
	 * overriden the view all products method
	 */
	@Override
	public Iterable<FoodCart> viewAllFoodCarts() {
		
		return foodcartRepository.findAll();
	}

}


