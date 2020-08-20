package com.salestaxcalculator.utility;

import java.text.DecimalFormat;

import com.salestaxcalculator.domain.ShoppingBasketItem;
/**
 * @author swethakotapati
 *
 */
public class ReceiptDisplay {
	
	DecimalFormat df = new DecimalFormat("##0.00");
	/**
	 * Displaying ShoppingBasketItem output details on console
	 */
    public void shoppingBasketItemList(ShoppingBasketItem sbItem) {
        System.out.println(sbItem.getQuantity() + " " + sbItem.getProduct().getDescription() +": " + df.format(sbItem.getAmountAfterTax()));
    }
    /**
	 * Displaying TotalSalesTax details on console
	 */
    public void totalSalesTaxDisplay(Double totalSalesTax) {
    	System.out.println("-------------------------------------------------");
        System.out.println("Sales Taxes:" +df.format(totalSalesTax));
    }
    /**
   	 * Displaying TotalAmount details on console
   	 */
    public void totalAmountDisplay(Double totalAmount) {
        System.out.println("Total:" +df.format(totalAmount));
    }



}
