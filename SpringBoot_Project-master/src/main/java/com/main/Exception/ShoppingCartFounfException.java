package com.main.Exception;

public class ShoppingCartFounfException extends RuntimeException{

	private String message;

	public ShoppingCartFounfException(String message)
	{
	   super(message);
	}

	public ShoppingCartFounfException()
	{
	   
	}

	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
	
	
}
