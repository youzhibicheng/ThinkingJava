package com.thoughtworks.test.salesTaxes.cart;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.test.salesTaxes.product.BasicProductDecorator;
import com.thoughtworks.test.salesTaxes.product.IProduct;
import com.thoughtworks.test.salesTaxes.product.ImportProductDecorator;
import com.thoughtworks.test.salesTaxes.product.Product;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;


public class ShoppingCartTest {
	
	@Test
	public void testCart1()  {
		ShoppingCart sc1 = new ShoppingCart();
		IProduct pa1 = new Product("book",12.49);
		IProduct pa2 = new BasicProductDecorator(
				new Product("music CD",14.99)
		);
		IProduct pa3 = new Product("chocolate bar",0.85);
		sc1.add(pa1);
		sc1.add(pa2);
		sc1.add(pa3);
		sc1.computeTax();
		assertEquals("1.50", DoubleUtil.double2String(sc1.getTotalTax()) );
		assertEquals("29.83", DoubleUtil.double2String(sc1.getTotal()) );
	}
	
	@Test
	public void testCart2()  {
		ShoppingCart pg2 = new ShoppingCart();
		IProduct pb1 = new ImportProductDecorator(
				new Product("box of chocolates",10.00)
		);
		IProduct pb2 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",47.50)
				)
		);
		pg2.add(pb1);
		pg2.add(pb2);
		pg2.computeTax();

		assertEquals("7.65", DoubleUtil.double2String(pg2.getTotalTax()) );
		assertEquals("65.15", DoubleUtil.double2String(pg2.getTotal()) );
	}
	
	@Test
	public void testCart3()  {
		ShoppingCart pg3 = new ShoppingCart();
		IProduct pc1 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",27.99)
				)
		);
		IProduct pc2 = new BasicProductDecorator(
				new Product("bottle of perfume",18.99)
		);
		IProduct pc3 = new Product("packet of headache pills",9.75);
		IProduct pc4 = new ImportProductDecorator(
				new Product("box of chocolatese",11.25)
		);
		pg3.add(pc1);
		pg3.add(pc2);
		pg3.add(pc3);
		pg3.add(pc4);
		pg3.computeTax();

		assertEquals("6.70", DoubleUtil.double2String(pg3.getTotalTax()) );
		assertEquals("74.68", DoubleUtil.double2String(pg3.getTotal()) );
	}
	
	@Test
	public void testAddRemove()  {
		ShoppingCart pg3 = new ShoppingCart();
		IProduct pc1 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",27.99)
				)
		);
		pg3.add(pc1);
		pg3.add(pc1);
		pg3.add(pc1);
		pg3.add(pc1);
		assertEquals(4, pg3.getItems().iterator().next().getQuantity() );

		pg3.remove(pc1);
		pg3.remove(pc1);
		assertEquals(2, pg3.getItems().iterator().next().getQuantity() );
		pg3.remove(pc1);
		pg3.remove(pc1);
		assertEquals(0, pg3.getItems().size() );
		pg3.remove(pc1);
		assertEquals(0, pg3.getItems().size() );
	}
}
