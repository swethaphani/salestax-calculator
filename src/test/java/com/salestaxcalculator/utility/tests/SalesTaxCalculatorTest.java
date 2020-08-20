package com.salestaxcalculator.utility.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.domain.ShoppingBasket;
import com.salestaxcalculator.domain.ShoppingBasketItem;
import com.salestaxcalculator.utility.SalesTaxCalculator;


public class SalesTaxCalculatorTest {
	
	ShoppingBasket shopCart;
	
    ShoppingBasketItem shopCartItem;
	
	@Test
	public void calculateTotals_import_success() {
		Product product = new Product();
		product.setDescription("imported bottle of perfume");
		product.setImported(true);
		product.setPrice(67.89);
		List<ShoppingBasketItem> shopCartItemList = new ArrayList<ShoppingBasketItem>();
		shopCartItem = new ShoppingBasketItem();
		shopCartItem.setProduct(product);
		shopCartItem.setQuantity(1);
		shopCartItemList.add(shopCartItem);
		shopCart = new ShoppingBasket();
		shopCart.setShoppingBasketItemList(shopCartItemList);		
		shopCart = SalesTaxCalculator.calculateTotals(shopCart);
		assertEquals(78.09,shopCart.getTotalAmount());
		assertEquals(10.2,shopCart.getTotalSalesTaxAmount());
		
	}
	
	@Test
	public void calculateTotals_exempt_success() {
		Product product = new Product();
		product.setDescription("packet of headache pills");
		product.setExempt(true);
		product.setPrice(9.75);
		List<ShoppingBasketItem> shopCartItemList = new ArrayList<ShoppingBasketItem>();
		shopCartItem = new ShoppingBasketItem();
		shopCartItem.setProduct(product);
		shopCartItem.setQuantity(1);
		shopCartItemList.add(shopCartItem);
		shopCart = new ShoppingBasket();
		shopCart.setShoppingBasketItemList(shopCartItemList);		
		shopCart = SalesTaxCalculator.calculateTotals(shopCart);
		assertEquals(9.75,shopCart.getTotalAmount());
		assertEquals(0.0,shopCart.getTotalSalesTaxAmount());
				
	}
	
	@Test
	public void calculateTotals_basicSalesTax_success() {
		Product product = new Product();
		product.setDescription("bottle of perfume");
		product.setPrice(18.99);
		List<ShoppingBasketItem> shopCartItemList = new ArrayList<ShoppingBasketItem>();
		shopCartItem = new ShoppingBasketItem();
		shopCartItem.setProduct(product);
		shopCartItem.setQuantity(1);
		shopCartItemList.add(shopCartItem);
		shopCart = new ShoppingBasket();
		shopCart.setShoppingBasketItemList(shopCartItemList);		
		shopCart = SalesTaxCalculator.calculateTotals(shopCart);
		assertEquals(20.89,shopCart.getTotalAmount());
		assertEquals(1.9,shopCart.getTotalSalesTaxAmount());
				
	}

	

}
