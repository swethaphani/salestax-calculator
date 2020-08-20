package com.salestaxcalculator.template.tests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.template.BasicSalesTax;

public class BasicSalesTaxTest{
	
	BasicSalesTax basicSalesTax;
	
	Product product;
	
	@BeforeEach
    public void setup(){
		basicSalesTax = new BasicSalesTax();
    }

	
	@Test
	public void getSalesTaxRate_success() {
		double stVal = basicSalesTax.getSalesTaxRate();
		assertEquals("0.1",String.valueOf(stVal));
	}

	@Test
	public void calculateSalesTax_basicSalesTax_success() {
		product = new Product();
		product.setPrice(18.49);
		double stVal = basicSalesTax.calculateSalesTax(product);
		assertEquals("1.85",String.valueOf(stVal));
	}

}
