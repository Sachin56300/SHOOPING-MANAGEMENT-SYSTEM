package com.main.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.Entity.ShoppingCart;
import com.main.Exception.ShoppingCartFounfException;
import com.main.Utility.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler 
{
    @ExceptionHandler
	public ResponseEntity<ResponseStructure<ShoppingCart>> shoppingNotFoundById(ShoppingCartFounfException ex)
	{
    	ResponseStructure<ShoppingCart> rs=new ResponseStructure<>();
    	rs.setStatusCode(HttpStatus.NOT_FOUND.value());
    	rs.setMessage(ex.getMessage());
    	rs.setExceptionData(ex.getClass().getSimpleName());
    	
    	
		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs,HttpStatus.NOT_FOUND);
		
	}
	
	
}
