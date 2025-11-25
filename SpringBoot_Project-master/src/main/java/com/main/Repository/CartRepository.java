package com.main.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.main.Entity.ShoppingCart;
import com.main.Utility.ResponseStructure;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart,String> {
	
	@Query("select s from ShoppingCart s where s.itemName LIKE %?1%")
	public List<ShoppingCart> findByName(String itemName);
	
	@Transactional
	@Modifying
	@Query("update ShoppingCart set itemName=:itemName where cartId= :cartId")
	public  Integer updateById(String itemName,String cartId);
	
	@Transactional
	@Modifying
	@Query("update ShoppingCart set cartId= :cartId  where itemName=:itemName")
	public  Integer updateByName(String cartId ,String itemName);

	@Transactional
	@Modifying
	@Query("update ShoppingCart set itemName=:itemName")
	public  Integer updateAll(String itemName);

	@Transactional
	@Modifying
	@Query("delete from ShoppingCart  where itemName=:itemName")
	public  Integer deleteByName(String itemName);


}
