package com.main.Utility;

import java.util.List;

import com.main.Exception.ShoppingCartFounfException;

public class ResponseStructure <ShoppingCart>
{

	private int statusCode;
	private String message;
	private ShoppingCart data;
    private List<ShoppingCart> alldata;
    private String exceptionData;
    
	
	public List<ShoppingCart> getAlldata() {
		return alldata;
	}
	public void setAlldata(List<ShoppingCart> alldata) {
		this.alldata = alldata;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ShoppingCart getData() {
		return data;
	}
	public void setData(ShoppingCart data) {
		this.data = data;
	}
	public String getExceptionData() {
		return exceptionData;
	}
	public void setExceptionData(String exceptionData) {
		this.exceptionData = exceptionData;
	}
	@Override
	public String toString() {
		return "ResponseStructure [statusCode=" + statusCode + ", message=" + message + ", data=" + data + ", alldata="
				+ alldata + ", exceptionData=" + exceptionData + "]";
	}
	
	
	
	
	
	
	
	
	
}
