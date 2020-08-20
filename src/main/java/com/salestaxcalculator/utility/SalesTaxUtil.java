package com.salestaxcalculator.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.salestaxcalculator.domain.ShoppingBasket;
import com.salestaxcalculator.domain.ShoppingBasketItem;

/**
 * @author swethakotapati
 *
 */
public class SalesTaxUtil {

	private static Set<String> exemptItems = null;

	static {
		exemptItems = new HashSet<String>();
		exemptItems.add("book");
		exemptItems.add("books");
		exemptItems.add("headache pills");
		exemptItems.add("packet of headache pills");
		exemptItems.add("box of imported chocolates");
		exemptItems.add("imported box of chocolates");
		exemptItems.add("box of chocolates");
		exemptItems.add("chocolate");
		exemptItems.add("chocolate bar");
		exemptItems.add("chocolate bars");
		exemptItems.add("pills");
	}

	/**
	 * Rounding value to the nearest 0.05
	 */
	public static double nearest5Percent(double amount) {
		return new BigDecimal(Math.ceil(amount * 20) / 20).setScale(3, RoundingMode.HALF_UP).doubleValue();

	}

	/**
	 * Rounding price
	 */
	public static double roundPrice(double amount) {
		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	/**
	 * Check if the product is exempt from salestax
	 */
	public static boolean isExempt(String name) {
		return exemptItems.contains(name);
	}

	/**
	 * Process Shopping basket list from the input file and then add to objects for
	 * tax and amount calculation and throws exception when error occurs during file
	 * read or processing
	 * 
	 */
	public static ShoppingBasket processDetails(String fileName) throws Exception {
		ShoppingBasket shopCart = new ShoppingBasket();
		ShoppingBasketItem shopCartItem = new ShoppingBasketItem();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			String receiptDetails;
			System.out.println("\nInput :");
			List<ShoppingBasketItem> scItemList = new ArrayList<ShoppingBasketItem>();
			while ((receiptDetails = bufferedReader.readLine()) != null) {
				System.out.println(receiptDetails);
				shopCartItem = ReceiptParser.parseReceipt(receiptDetails);
				scItemList.add(shopCartItem);
			}
			shopCart.setShoppingBasketItemList(scItemList);
			shopCart = SalesTaxCalculator.calculateTotals(shopCart);
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			throw new Exception();
		}
		return shopCart;
	}
}