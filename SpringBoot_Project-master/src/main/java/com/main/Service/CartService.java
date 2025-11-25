package com.main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.Entity.ShoppingCart;
import com.main.Exception.ShoppingCartFounfException;

import com.main.Repository.CartRepository;
import com.main.Utility.ResponseStructure;

@Service
public class CartService {
	@Autowired
	public CartRepository cartRepository;

	public ResponseEntity<ResponseStructure<ShoppingCart>> insertByElement(ShoppingCart shoppingcart) {
		ShoppingCart save = cartRepository.save(shoppingcart);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("One ShoppingCart Object is Sccessfully Inserted!!");
		rs.setData(save);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> insertAll(List<ShoppingCart> shoppingcart) {
		List<ShoppingCart> saveAll = cartRepository.saveAll(shoppingcart);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("All ShoppingCart Objects are Sccessfully Inserted!!");
		rs.setAlldata(saveAll);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.CREATED);
	}
	
	


	public ResponseEntity<ResponseStructure<ShoppingCart>> findById(String id) {
		Optional<ShoppingCart> fbid = cartRepository.findById(id);
		ResponseStructure<ShoppingCart> rs = null;

		if (fbid.isPresent()) {
			ShoppingCart scart = fbid.get();

			rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage("ShoppingCart Object Found Successfully!!");
			rs.setData(scart);

			return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.FOUND);
		} else {
			
//			rs = new ResponseStructure<>();
//			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
//			rs.setMessage("ShoppingCart Object with " + id + " Not Found");
//			rs.setExceptionData(new ShoppingCartFounfException().getClass().getSimpleName());
//
//			return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.NOT_FOUND);
			
			throw new ShoppingCartFounfException("ShoppingCart Object with" + id +" Not Found");
			
		}

	}
	
	
	
	
	

	public ResponseEntity<ResponseStructure<ShoppingCart>> findByName(String itemName) {
		List<ShoppingCart> findByName = cartRepository.findByName(itemName);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("ShoppingCart Objects Found Successfully!!");
		rs.setAlldata(findByName);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> findAll() {
		List<ShoppingCart> findall = cartRepository.findAll();

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("All ShoppingCart Objects Found Successfully!!");
		rs.setAlldata(findall);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateById(String itemName, String cartId) {
		Integer updateById = cartRepository.updateById(itemName, cartId);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage(updateById + "ShoppingCart Records UpdatedById Successfully!!");

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateByName(String cartId, String itemName) {
		Integer updateByName = cartRepository.updateByName(cartId, itemName);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage(updateByName + " ShoppingCart Records UpdatedByName Successfully!!");

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateAll(String itemName) {
		Integer updateall = cartRepository.updateAll(itemName);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage(updateall + " ShoppingCart Records UpdatedAll Successfully!!");

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteById(String cartId) {
		cartRepository.deleteById(cartId);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("ShoppingCart Object Removed by ID Successfully!! " + cartId);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteByName(String itemName) {
		Integer deleteByName = cartRepository.deleteByName(itemName);

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage(deleteByName + " ShoppingCart Object Removed by iteamName Successfully!! " + itemName);

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteAll() {
		cartRepository.deleteAll();

		ResponseStructure<ShoppingCart> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("All ShoppingCart Objects Removed Successfully!! ");

		return new ResponseEntity<ResponseStructure<ShoppingCart>>(rs, HttpStatus.OK);
	}

}
