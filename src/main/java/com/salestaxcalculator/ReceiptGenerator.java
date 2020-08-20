package com.salestaxcalculator;

import com.salestaxcalculator.domain.ShoppingBasket;
import com.salestaxcalculator.domain.ShoppingBasketItem;
import com.salestaxcalculator.utility.ReceiptDisplay;
import com.salestaxcalculator.utility.SalesTaxUtil;

/**
 * @author swethakotapati
 *
 */
public class ReceiptGenerator {

	public static void main(String[] shoppingBaskets) throws Exception {
		String[] basketLocation = { "src/main/resources/receipt1.txt", "src/main/resources/receipt2.txt",
				"src/main/resources/receipt3.txt", "src/main/resources/receipt4.txt" };
		String[] shoppingBasketFiles = (shoppingBaskets.length > 0) ? shoppingBaskets : basketLocation;
		for (String fileName : shoppingBasketFiles) {
			ShoppingBasket shopCart = SalesTaxUtil.processDetails(fileName);
			ReceiptDisplay display = new ReceiptDisplay();
			System.out.println("\nOutput :");
			for (ShoppingBasketItem item : shopCart.getShoppingBasketItemList()) {
				display.shoppingBasketItemList(item);
			}
			display.totalSalesTaxDisplay(shopCart.getTotalSalesTaxAmount());
			display.totalAmountDisplay(shopCart.getTotalAmount());
		}

	}

}
