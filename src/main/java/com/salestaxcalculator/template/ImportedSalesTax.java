package com.salestaxcalculator.template;


/**
 * @author swethakotapati
 *
 */
public class ImportedSalesTax extends SalesTax{
	
	//Sales tax of 5% for imported items
	final double rate = 0.05;
	
	@Override
	public double getSalesTaxRate() {
		return this.rate;
	}
	

}
