package com.cg.fda.web;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.fda.domain.FoodCart;
import com.cg.fda.service.FoodCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FoodCartWebTest {

	@Autowired
	    private MockMvc mockMvc;
		
		  @MockBean
		  private FoodCartService foodcartService;
		  
		 
	@Test
	void  testAddFoodCarts() throws Exception {
		
		  FoodCart foodcart= new FoodCart(); 
		  String uri="/api/v2/Carts";
		  foodcart.setFoodCartId(1);
		  foodcart.setFoodItemName("Biryani");
		  foodcart.setFoodItemQuantity("2");
		  foodcart.setFoodItemPrice(200);
		  
		  String jsonInput=this.converttoJson(foodcart);
		  Mockito.when(foodcartService.addFoodCarts(Mockito.any(FoodCart.class))).thenReturn(foodcart);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
		                            .accept(MediaType.APPLICATION_JSON)
		                            .content(jsonInput)
		                            .contentType(MediaType.APPLICATION_JSON))
				                    .andReturn();
		  
			
			 
			  Assert.assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
		 
	}
	 @Test
		void testDeleteFoodCart() throws Exception {
			FoodCart foodcart= new FoodCart(); 
			  String uri="/api/v2/{foodCartId}";
			  foodcart.setFoodCartId(2);
			  foodcart.setFoodItemName("panner");
			  foodcart.setFoodItemQuantity("02");
			  foodcart.setFoodItemPrice(200);
			  //product.setQuantity(309);
			  int foodcartId=foodcart.getFoodCartId();
			  String jsonInput=this.converttoJson(foodcart);
				
				  Mockito.when(foodcartService.viewFoodCartByFoodCartId(foodcartId)).thenReturn( foodcart);
				  Mockito.when(foodcartService.deleteFoodCart(foodcartId)).thenReturn(foodcart);
				 
			  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,2)
			                            .accept(MediaType.APPLICATION_JSON)
			                            .content(jsonInput)
			                            .contentType(MediaType.APPLICATION_JSON))
					                    .andReturn();
			 
			  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			  
	 }
	 @Test
	 void testViewAllFoodCart() throws Exception {
		 
		 String uri="/api/v2/all";
		 FoodCart foodcart1=new FoodCart();
		 foodcart1.setFoodCartId(1);
		 foodcart1.setFoodItemName("biryani");
		 foodcart1.setFoodItemQuantity("02");
		 foodcart1.setFoodItemPrice(300);
		// foodcart1.setQuantity(300);
		  
		  FoodCart foodcart2=new FoodCart();
		  foodcart2.setFoodCartId(2);
		  foodcart2.setFoodItemName("panner");
		  foodcart2.setFoodItemQuantity("2");
		  foodcart2.setFoodItemPrice(200);
		  //product2.setQuantity(309);
		  
		  List<FoodCart> foodcartList=new ArrayList<FoodCart>();
		  foodcartList.add(foodcart1);
		  foodcartList.add(foodcart2);		  
		  String jsonInput=this.converttoJson(foodcartList);
		  Mockito.when(foodcartService.viewAllFoodCarts()).thenReturn(foodcartList);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
               .accept(MediaType.APPLICATION_JSON)
               .content(jsonInput)
               .contentType(MediaType.APPLICATION_JSON))
               .andReturn();
             
     Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
	 }

	 @Test
	 void testViewFoodCartById() throws Exception {
		 String uri="/api/v2/{foodCartId}" ;
		 FoodCart foodcart=new FoodCart();		 
		 foodcart.setFoodCartId(2);
		 foodcart.setFoodItemName("panner");
		 foodcart.setFoodItemQuantity("2");
		 foodcart.setFoodItemPrice(200);
		 // product.setQuantity(309);
		  String jsonInput=this.converttoJson(foodcart);
		  
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,2)
               .accept(MediaType.APPLICATION_JSON)
               .content(jsonInput)
               .contentType(MediaType.APPLICATION_JSON))
               .andReturn();
		 
		  Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
				 
	 }
	 @Test
	 void testUpdateFoodCart() throws Exception {
		 String uri= "/api/v2/{foodCartId}";
		 FoodCart foodcart=new FoodCart();		 
		 foodcart.setFoodCartId(1);
		 foodcart.setFoodItemName("biryani");
		 foodcart.setFoodItemQuantity("2");
		 foodcart.setFoodItemPrice(300);
		  //product.setQuantity(309);
		  String jsonInput=this.converttoJson(foodcart);
		  Mockito.when(foodcartService.updateFoodCart(foodcart, 2)).thenReturn(foodcart);
		  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(uri,5)
               .accept(MediaType.APPLICATION_JSON)
               .content(jsonInput)
               .contentType(MediaType.APPLICATION_JSON))
               .andReturn();
		  Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		  		 
	 }

	 private String converttoJson(Object product) throws JsonProcessingException {
			ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(product);
		}

	 
}

