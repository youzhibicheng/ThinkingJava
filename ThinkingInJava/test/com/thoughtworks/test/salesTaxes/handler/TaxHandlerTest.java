package com.thoughtworks.test.salesTaxes.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.test.salesTaxes.handler.ITaxHandler;
import com.thoughtworks.test.salesTaxes.handler.TaxHandler1;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;



public class TaxHandlerTest {
	@Test
	public void testTaxHandler()  {
		TaxHandlerFactory factory = new TaxHandlerFactory();
		ITaxHandler cp1 = factory.getTaxHandler("1");
		ITaxHandler cp2 = new TaxHandler1();		
		assertEquals(cp1.getClass(), cp2.getClass());
		System.out.println(DoubleUtil.double2String(cp1.handleTax(3.1000)));
		assertEquals("3.10", DoubleUtil.double2String(cp1.handleTax(3.1000) ));
		assertEquals("3.15", DoubleUtil.double2String(cp1.handleTax(3.1022) ));
		assertEquals("3.20", DoubleUtil.double2String(cp1.handleTax(3.15000) ));
		assertEquals("3.20", DoubleUtil.double2String(cp1.handleTax(3.1800) ));
	}
}
