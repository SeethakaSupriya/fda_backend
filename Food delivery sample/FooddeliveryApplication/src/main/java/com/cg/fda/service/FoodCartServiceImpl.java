package com.cg.fda.service;

import com.cg.fda.exception.FoodCartIdNotFoundException;
import com.cg.fda.domain.FoodCart;

/**
 * 
 * @author supriya
 *Description : interface of cart service is provided
 * to perform the crud operations on the cart
 */
public interface FoodCartServiceImpl {

	/**
	 * this method will add the cart
	 * @param product
	 * @return product
	 */
	public FoodCart addFoodCarts(FoodCart foodcart);
	/**
	 * this method will delete the foodcart
	 * @param foodcartId
	 * @return foodcart
	 */
	public FoodCart deleteFoodCart(int foodCartId);
	/**
	 * this method will update the cartdetails
	 * @param cart
	 * @param cartId
	 * @return cart
	
	 */
	public FoodCart updateFoodCart(FoodCart foodcart,int foodCartId) throws FoodCartIdNotFoundException;
	/**
	 * this method will display all the carts
	 * @return list of carts
	 */
	public Iterable<FoodCart> viewAllFoodCarts();
	/**
	 * this method will display view productDetails based on id
	 * @param productId
	 * @return product
	 * @throws ProductIdNotFoundException
	 */
	public FoodCart viewFoodCartByFoodCartId(int foodCartId) throws FoodCartIdNotFoundException;
}

