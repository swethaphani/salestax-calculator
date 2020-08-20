package com.salestaxcalculator.domain;

import java.util.List;

/**
 * @author swethakotapati
 *
 */
public class ShoppingBasket {

	/**
	 * List of ShoppingBasketItems
	 */
	private List<ShoppingBasketItem> shoppingBasketItemList;
	/**
	 * Total sales tax amount to be paid
	 */
	private double totalSalesTaxAmount;
	/**
	 * Total amount customer to be paid including sales tax
	 */
	private double totalAmount;

	/**
	 * @return the shoppingBasketItemList
	 */
	public List<ShoppingBasketItem> getShoppingBasketItemList() {
		return shoppingBasketItemList;
	}

	/**
	 * @param shoppingBasketItemList the shoppingBasketItemList to set
	 */
	public void setShoppingBasketItemList(List<ShoppingBasketItem> shoppingBasketItemList) {
		this.shoppingBasketItemList = shoppingBasketItemList;
	}

	/**
	 * @return the totalSalesTaxAmount
	 */
	public double getTotalSalesTaxAmount() {
		return totalSalesTaxAmount;
	}

	/**
	 * @param totalSalesTaxAmount the totalSalesTaxAmount to set
	 */
	public void setTotalSalesTaxAmount(double totalSalesTaxAmount) {
		this.totalSalesTaxAmount = totalSalesTaxAmount;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "ShoppingBasket [shoppingBasketItemList=" + shoppingBasketItemList + ", totalSalesTaxAmount="
				+ totalSalesTaxAmount + ", totalAmount=" + totalAmount + "]";
	}

	
}
