package com.salestaxcalculator.template.tests;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.template.ImportedBasicSalesTax;

public class ImportedBasicSalesTaxTest{
	
	ImportedBasicSalesTax impBasicSalesTax;
	
	Product product;
	
	@BeforeEach
    public void setup(){
		impBasicSalesTax = new ImportedBasicSalesTax();
    }

	
	@Test
	public void getSalesTaxRate_success() {
		double stVal = impBasicSalesTax.getSalesTaxRate();
		assertEquals("0.15",String.valueOf(stVal));
	}
	
	@Test
	public void calculateSalesTax_importedBasicSalesTax_success() {
		product = new Product();
		product.setPrice(15.49);
		double stVal = impBasicSalesTax.calculateSalesTax(product);
		assertEquals("2.35",String.valueOf(stVal));
	}


}
