package com.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entity.ShoppingCart;
import com.main.Service.CartService;
import com.main.Utility.ResponseStructure;

@RestController
public class CartController 
{

	@Autowired
	public CartService cartService;
	
	@PostMapping("/insertByElement")
	public ResponseEntity<ResponseStructure<ShoppingCart>> insertByElement(@RequestBody ShoppingCart shoppingCart)
	{
		return cartService.insertByElement(shoppingCart);
	}
	
	@PostMapping("/insertAll")
	public ResponseEntity<ResponseStructure<ShoppingCart>> insertAll(@RequestBody List<ShoppingCart> shoppingCart)
	{
		return cartService.insertAll(shoppingCart);
	}
	
	@GetMapping("/findbyid/{cartId}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> findById(@PathVariable String cartId)
	{
		return cartService.findById(cartId);
	}
	
	@GetMapping("/findbyname/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> findByName(@PathVariable String itemName)
	{
		return cartService.findByName(itemName);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<ShoppingCart>> findAll()
	{
		return cartService.findAll();
	}
	
	@PutMapping("/updatebyid/{itemName}/{cartId}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateById(@PathVariable String itemName,@PathVariable String cartId)
	{
		return cartService.updateById(itemName, cartId);
	}
	
	@PutMapping("/updatebyname/{cartId}/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateByName(@PathVariable String cartId,@PathVariable String itemName)
	{
		return cartService.updateByName(cartId, itemName);
	}
	
	@PutMapping("/updateall/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateAll(@PathVariable String itemName)
	{
		return cartService.updateAll(itemName);
	}
	
	@DeleteMapping("/deletebyid/{cartId}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteById(@PathVariable String cartId)
	{
		return cartService.deleteById(cartId);
	}
	
	@DeleteMapping("/deletebyname/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteByName(@PathVariable String itemName)
	{
		return cartService.deleteByName(itemName);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteAll()
	{
		return cartService.deleteAll();
	}
	
	
	
	
}
