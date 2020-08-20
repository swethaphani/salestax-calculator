package com.salestaxcalculator.domain;

/**
 * @author swethakotapati
 *
 */
public class ShoppingBasketItem {
	/**
	 * Details of the product for the Item
	 */
	private Product product;
	/**
	 * Number of quantity of the item
	 */
	private int quantity;
	/**
	 * SalesTaxAmount for the item
	 */
	private double salesTaxAmount;
	/**
	 * TotalAmount for the item including sales tax amount
	 */
	private double amountAfterTax;

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the salesTaxAmount
	 */
	public double getSalesTaxAmount() {
		return salesTaxAmount;
	}

	/**
	 * @param salesTaxAmount the salesTaxAmount to set
	 */
	public void setSalesTaxAmount(double salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}

	/**
	 * @return the amountAfterTax
	 */
	public double getAmountAfterTax() {
		return amountAfterTax;
	}

	/**
	 * @param amountAfterTax the amountAfterTax to set
	 */
	public void setAmountAfterTax(double amountAfterTax) {
		this.amountAfterTax = amountAfterTax;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [product=" + product + ", quantity=" + quantity + ", salesTaxAmount=" + salesTaxAmount
				+ ", amountAfterTax=" + amountAfterTax + "]";
	}

}
