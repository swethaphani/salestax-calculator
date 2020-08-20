package com.salestaxcalculator.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.salestaxcalculator.domain.Product;
import com.salestaxcalculator.domain.ShoppingBasketItem;

/**
 * @author swethakotapati
 *
 */
public class ReceiptParser {

	private static final String ITEM_QUANTITY_REGEX = "^[\\d+]+";
	private static final String ITEM_DETAILS_REGEX = "(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)";
	private static final String ITEM_PRICE_REGEX = "\\d+.\\d+$";

	/**
	 * Parsing Shopping basket details from input file and setting imported and
	 * exempted parameters
	 */
	public static ShoppingBasketItem parseReceipt(String order) {
		ShoppingBasketItem shBasketItem = new ShoppingBasketItem();
		shBasketItem.setQuantity(scanQty(order));
		Product product = new Product();
		product.setDescription(scanDetails(order));
		product.setPrice(scanPrice(order));
		if (product.getDescription().contains("imported"))
			product.setImported(true);
		if (SalesTaxUtil.isExempt(product.getDescription()))
			product.setExempt(true);
		shBasketItem.setProduct(product);
		return shBasketItem;
	}

	/**
	 * Match Quantity value from input data
	 */
	private static int scanQty(String details) {
		Pattern p = Pattern.compile(ITEM_QUANTITY_REGEX);
		Matcher m = p.matcher(details);
		m.find();
		return Integer.parseInt(m.group(0));
	}

	/**
	 * Match product details from input data
	 */
	private static String scanDetails(String details) {
		Pattern p = Pattern.compile(ITEM_DETAILS_REGEX);
		Matcher m = p.matcher(details);
		m.find();
		return m.group(0);
	}
	/**
	 * Match price details from input data
	 */
	private static Double scanPrice(String details) {
		Pattern p = Pattern.compile(ITEM_PRICE_REGEX);
		Matcher m = p.matcher(details);
		m.find();
		return Double.parseDouble(m.group(0));
	}
}
