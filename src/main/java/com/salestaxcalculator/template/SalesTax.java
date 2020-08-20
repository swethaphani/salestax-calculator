package com.salestaxcalculator.template;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.utility.SalesTaxUtil;
/**
 * @author swethakotapati
 *
 */
abstract class SalesTax {
	
  abstract double getSalesTaxRate();
  
  protected double rate;
    
    public double calculateSalesTax (Product product) { 
      return SalesTaxUtil.nearest5Percent(product.getPrice() * this.getSalesTaxRate()); 
    }

}
