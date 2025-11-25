package com.main.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ShoppingCart 
{
    @Id
	private String cartId;
	private String itemName;
	private String noOfItems;

	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}
	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", itemName=" + itemName + ", noOfItems=" + noOfItems + "]";
	}
	
	
}
