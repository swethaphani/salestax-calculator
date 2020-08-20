package com.salestaxcalculator.domain;

/**
 * @author swethakotapati
 *
 */
public class Product {

	/**
	 * Price of the individual product
	 */
	private double price;
	/**
	 * Description of the product
	 */
	private String description;
	/**
	 * Flag to check if the product is imported
	 */
	private boolean isImported = false;
	/**
	 * Flag to check if the product is Exempt from taxes
	 */
	private boolean isExempt = false;

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the isImported
	 */
	public boolean isImported() {
		return isImported;
	}

	/**
	 * @param isImported the isImported to set
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	/**
	 * @return the isExempt
	 */
	public boolean isExempt() {
		return isExempt;
	}

	/**
	 * @param isExempt the isExempt to set
	 */
	public void setExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", description=" + description + ", isImported=" + isImported + ", isExempt="
				+ isExempt + "]";
	}

}
