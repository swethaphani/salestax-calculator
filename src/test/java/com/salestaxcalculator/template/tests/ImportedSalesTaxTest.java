package com.salestaxcalculator.template.tests;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.template.ImportedSalesTax;

public class ImportedSalesTaxTest{
	
	ImportedSalesTax impSalesTax;
	
	Product product;
	
	@BeforeEach
    public void setup(){
		impSalesTax = new ImportedSalesTax();
    }

	
	@Test
	public void getSalesTaxRate_success() {
		double stVal = impSalesTax.getSalesTaxRate();
		assertEquals("0.05",String.valueOf(stVal));
	}
	
	@Test
	public void calculateSalesTax_importedSalesTax_success() {
		product = new Product();
		product.setPrice(12.49);
		double stVal = impSalesTax.calculateSalesTax(product);
		assertEquals("0.65",String.valueOf(stVal));
	}


}
