package com.salestaxcalculator.template;

/**
 * @author swethakotapati
 *
 */
public class ImportedBasicSalesTax extends SalesTax{
	//Sales tax of 15% for imported and basic items
	final double rate = 0.15;
	
	@Override
	public double getSalesTaxRate() {
		return this.rate;
	}
	

}
