package com.salestaxcalculator.utility;

import com.salestaxcalculator.domain.ShoppingBasket;
import com.salestaxcalculator.domain.ShoppingBasketItem;
import com.salestaxcalculator.template.BasicSalesTax;
import com.salestaxcalculator.template.ImportedBasicSalesTax;
import com.salestaxcalculator.template.ImportedSalesTax;

/**
 * @author swethakotapati
 *
 */
public class SalesTaxCalculator {

	/**
	 * Calculating individual item sales tax amount and individual item total amount
	 * including sales tax.
	 */
	public static ShoppingBasket calculateTotals(ShoppingBasket shopCart) {

		BasicSalesTax sbTax = new BasicSalesTax();
		ImportedSalesTax impTax = new ImportedSalesTax();
		ImportedBasicSalesTax impBasTax = new ImportedBasicSalesTax();

		for (ShoppingBasketItem shopBasketItem : shopCart.getShoppingBasketItemList()) {

			if (shopBasketItem.getProduct().isImported() && !(shopBasketItem.getProduct().isExempt())) {
				shopBasketItem.setSalesTaxAmount(
						impBasTax.calculateSalesTax(shopBasketItem.getProduct()) * shopBasketItem.getQuantity());
				shopBasketItem.setAmountAfterTax(
						SalesTaxUtil.roundPrice((shopBasketItem.getProduct().getPrice() * shopBasketItem.getQuantity())
								+ shopBasketItem.getSalesTaxAmount()));
			} else if (shopBasketItem.getProduct().isImported()) {
				shopBasketItem.setSalesTaxAmount(
						impTax.calculateSalesTax(shopBasketItem.getProduct()) * shopBasketItem.getQuantity());
				shopBasketItem.setAmountAfterTax(
						SalesTaxUtil.roundPrice((shopBasketItem.getProduct().getPrice() * shopBasketItem.getQuantity())
								+ shopBasketItem.getSalesTaxAmount()));
			} else if (!(shopBasketItem.getProduct().isExempt())) {
				shopBasketItem.setSalesTaxAmount(
						sbTax.calculateSalesTax(shopBasketItem.getProduct()) * shopBasketItem.getQuantity());
				shopBasketItem.setAmountAfterTax(
						SalesTaxUtil.roundPrice((shopBasketItem.getProduct().getPrice() * shopBasketItem.getQuantity())
								+ shopBasketItem.getSalesTaxAmount()));
			} else {
				shopBasketItem.setAmountAfterTax(shopBasketItem.getProduct().getPrice() * shopBasketItem.getQuantity());
			}

		}
		calculateTotal(shopCart);
		return shopCart;
	}
	
	/**
	 * Calculating total shopping basket sales tax amount and shopping basket total amount
	 * including sales tax.
	 */
	public static void calculateTotal(ShoppingBasket shopBasket) {
		double taxtotal = 0.0;
		double totalCost = 0.0;
		for (ShoppingBasketItem shopBasketItem : shopBasket.getShoppingBasketItemList()) {
			taxtotal += shopBasketItem.getSalesTaxAmount();
			totalCost += shopBasketItem.getAmountAfterTax();
		}
		shopBasket.setTotalSalesTaxAmount(SalesTaxUtil.roundPrice(taxtotal));
		shopBasket.setTotalAmount(SalesTaxUtil.roundPrice(totalCost));

	}

}
