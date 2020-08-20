package com.salestaxcalculator.utility.tests;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.ShoppingBasket;
import com.salestaxcalculator.utility.SalesTaxUtil;



public class SalesTaxUtilTest {
	
 	
	@Test
	public void nearest5Percent_validation() {
		assertTrue(Math.abs((SalesTaxUtil.nearest5Percent(2.03)) - 2.05) < 0.0001);
	}

	@Test
	public void roundPrice_validation() {
		assertTrue(Math.abs((SalesTaxUtil.roundPrice(11.125456) - 11.12)) > 0.008);
	}

	@Test
	public void isExempt_Validation() {
		assertTrue(SalesTaxUtil.isExempt("chocolate bar"));
	}

	@Test
	public void processDetailsFromFile_success() throws Exception {
		ShoppingBasket shopCart = SalesTaxUtil.processDetails("src/test/resources/receipt1test.txt");
		assertEquals(3,shopCart.getShoppingBasketItemList().size());
		assertEquals(1,shopCart.getShoppingBasketItemList().get(0).getQuantity());
		assertEquals("book",shopCart.getShoppingBasketItemList().get(0).getProduct().getDescription());
		assertEquals(true,shopCart.getShoppingBasketItemList().get(0).getProduct().isExempt());
		assertEquals(false,shopCart.getShoppingBasketItemList().get(0).getProduct().isImported());
		assertEquals(1,shopCart.getShoppingBasketItemList().get(1).getQuantity());
		assertEquals("music CD",shopCart.getShoppingBasketItemList().get(1).getProduct().getDescription());
		assertEquals(false,shopCart.getShoppingBasketItemList().get(1).getProduct().isExempt());
		assertEquals(false,shopCart.getShoppingBasketItemList().get(1).getProduct().isImported());
	}
	
	@Test
	public void processDetailsFromFile_multiplesuccess() throws Exception {
		ShoppingBasket shopCart = SalesTaxUtil.processDetails("src/test/resources/receipt2test.txt");
		assertEquals(3,shopCart.getShoppingBasketItemList().size());
		assertEquals(2,shopCart.getShoppingBasketItemList().get(0).getQuantity());
		assertEquals("books",shopCart.getShoppingBasketItemList().get(0).getProduct().getDescription());
		assertEquals(true,shopCart.getShoppingBasketItemList().get(0).getProduct().isExempt());
		assertEquals(false,shopCart.getShoppingBasketItemList().get(0).getProduct().isImported());
		assertEquals(2,shopCart.getShoppingBasketItemList().get(2).getQuantity());
		assertEquals("chocolate bars",shopCart.getShoppingBasketItemList().get(2).getProduct().getDescription());
		assertEquals(true,shopCart.getShoppingBasketItemList().get(2).getProduct().isExempt());
		assertEquals(false,shopCart.getShoppingBasketItemList().get(2).getProduct().isImported());
	}

}
