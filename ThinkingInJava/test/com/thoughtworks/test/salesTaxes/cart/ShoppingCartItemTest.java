package com.thoughtworks.test.salesTaxes.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.test.salesTaxes.product.BasicProductDecorator;
import com.thoughtworks.test.salesTaxes.product.IProduct;
import com.thoughtworks.test.salesTaxes.product.ImportProductDecorator;
import com.thoughtworks.test.salesTaxes.product.Product;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;


public class ShoppingCartItemTest {
	@Test
	public void testItem()  {
		IProduct pc1 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",27.99)
				)
		);
		ShoppingCartItem pg3 = new ShoppingCartItem(pc1);
		pg3.incrementQuantity();
		pg3.incrementQuantity();
		assertEquals("3 imported bottle of perfume at 83.97", pg3.toString() );
		pg3.decrementQuantity();
		assertEquals("2 imported bottle of perfume at 55.98", pg3.toString() );
	}
}
