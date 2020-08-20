package com.salestaxcalculator.template;

/**
 * @author swethakotapati
 *
 */
public class BasicSalesTax extends SalesTax{
	//Sales tax of 10% for imported items
	final double rate = 0.1;

	@Override
	public double getSalesTaxRate() {
		return this.rate;
	}
	

}
