package com.salestaxcalculator.utility.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.ShoppingBasketItem;
import com.salestaxcalculator.utility.ReceiptParser;

public class ReceiptParserTest {
	

	@Test
	public void parseReceipt_exemptProduct() {
		ShoppingBasketItem shoppingCartItem = ReceiptParser.parseReceipt("1 book at 15.59");
		assertEquals("book", shoppingCartItem.getProduct().getDescription(), "book");
		assertEquals(1, shoppingCartItem.getQuantity(), 1);
		assertEquals(true, shoppingCartItem.getProduct().isExempt());
		assertEquals(false, shoppingCartItem.getProduct().isImported());
	}
	
	@Test
	public void parseReceipt_importedProduct() {
		ShoppingBasketItem shoppingCartItem = ReceiptParser.parseReceipt("2 imported bottle of perfume at 47.59");
		assertEquals("imported bottle of perfume",shoppingCartItem.getProduct().getDescription());
		assertEquals(2,shoppingCartItem.getQuantity());
		assertEquals(false, shoppingCartItem.getProduct().isExempt());
		assertEquals(true, shoppingCartItem.getProduct().isImported());
		
	}

}
