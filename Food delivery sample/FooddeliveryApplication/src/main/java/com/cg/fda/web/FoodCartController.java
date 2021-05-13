package com.cg.fda.web;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fda.exception.FoodCartIdNotFoundException;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.service.FoodCartService;




/**
 *Description:Controller for cart is given 
 * @author supriya
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class FoodCartController {
	private static final Logger logger = LogManager.getLogger(FoodCartController.class);
	@Autowired
	private FoodCartService foodcartService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * add cart is implemented in controller
	 * @param  cart
	 * @param result
	 * @return either errorMap or new product
	 */
	@PostMapping("/Carts")
	public ResponseEntity<?> addFoodCart(@Valid @RequestBody FoodCart foodcart,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		FoodCart newFoodCart=foodcartService.addFoodCarts(foodcart);
		logger.info(" cart is added successfully...!");
		return new ResponseEntity<>(newFoodCart,HttpStatus.CREATED);
		
	}
	/**
	 * delete FoodCart is implemented
	 * @param FoodCartId
	 * @return string saying FoodCart is deleted
	 */
	@DeleteMapping("/{foodCartId}")
	public ResponseEntity<String> deleteFoodCart(@PathVariable int foodCartId){
		foodcartService.deleteFoodCart(foodCartId);
		logger.info(" cart is deleted successfully...!");
		return new ResponseEntity<>("Food item with Id : "+foodCartId+" id deleted.....", HttpStatus.OK);
		
	}
	/**
	 * to display cart by FoodCartId
	 * @param FoodCartId
	 * @return the FoodCart we want 
	 * @throws FoodCartIdNotFoundException
	 */
	@GetMapping("/{foodCartId}")
	public ResponseEntity<FoodCart> viewFoodCartByFoodCartId(@PathVariable int foodCartId) throws FoodCartIdNotFoundException{		
		logger.info(" Retrieved cart by id successfully...!");
		return new ResponseEntity<>(foodcartService.viewFoodCartByFoodCartId(foodCartId),HttpStatus.OK);
		
	}
	/**
	 * displays all the carts
	 * @return all carts present in database
	 */
	@GetMapping("/all")
	public Iterable<FoodCart> viewAllFoodCarts(){
		logger.info(" All the FoodCarts are retrieved successfully...!");
		return foodcartService.viewAllFoodCarts();
		
	}
	/**
	 * method to update the FoodCart
	 * @param FoodCart
	 * @param FoodCartId
	 * @return updated FoodCart
	 * @throws FoodCartIdNotFoundException
	 */
	@PutMapping("/{foodCartId}")
	public ResponseEntity<FoodCart> updateFoodCart(@RequestBody FoodCart foodcart ,@PathVariable int foodCartId) throws FoodCartIdNotFoundException{
		FoodCart updatedFoodCart=foodcartService.updateFoodCart(foodcart,foodCartId);
		logger.info("FoodCart is updated successfully...!");
		return new ResponseEntity<>(updatedFoodCart,HttpStatus.OK);
		
	}

}


