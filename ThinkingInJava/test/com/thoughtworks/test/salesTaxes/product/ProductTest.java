package com.thoughtworks.test.salesTaxes.product;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.test.salesTaxes.util.DoubleUtil;


public class ProductTest {
	@Test
	public void testGroup1()  {
		IProduct pa1 = new Product("book",12.49);
		pa1.computeTax();
		assertEquals("0.00", DoubleUtil.double2String(pa1.getTax()) );
		
		IProduct pa2 = new BasicProductDecorator(
				new Product("music CD",14.99)
		);
		pa2.computeTax();
		assertEquals("1.50", DoubleUtil.double2String(pa2.getTax()) );
		
		IProduct pa3 = new Product("chocolate bar",0.85);
		pa3.computeTax();
		assertEquals("0.00", DoubleUtil.double2String(pa3.getTax()) );
	}
	
	@Test
	public void testGroup2()  {
		IProduct pb1 = new ImportProductDecorator(
				new Product("box of chocolates",10.00)
		);
		pb1.computeTax();
		assertEquals("0.50", DoubleUtil.double2String(pb1.getTax()) );
		
		IProduct pb2 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",47.50)
				)
		);
		pb2.computeTax();
		assertEquals("7.15", DoubleUtil.double2String(pb2.getTax()) );
	}
	
	@Test
	public void testGroup3()  {
		IProduct pc1 = new ImportProductDecorator(
				new BasicProductDecorator(
						new Product("bottle of perfume",27.99)
				)
		);
		pc1.computeTax();
		assertEquals("4.20", DoubleUtil.double2String(pc1.getTax()) );
		
		IProduct pc2 = new BasicProductDecorator(
				new Product("bottle of perfume",18.99)
		);
		pc2.computeTax();
		assertEquals("1.90", DoubleUtil.double2String(pc2.getTax()) );
		
		IProduct pc3 = new Product("packet of headache pills",9.75);
		pc3.computeTax();
		assertEquals("0.00", DoubleUtil.double2String(pc3.getTax()) );
		
		IProduct pc4 = new ImportProductDecorator(
				new Product("box of chocolatese",11.25)
		);
		pc4.computeTax();
		assertEquals("0.60", DoubleUtil.double2String(pc4.getTax()) );
	}
}
