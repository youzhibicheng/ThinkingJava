package com.thoughtworks.test.salesTaxes.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DoubleUtilTest {
	@Test
	public void testDouble2String1()  {
		assertEquals("3.00", DoubleUtil.double2String(3.0000));
		assertEquals("3.00", DoubleUtil.double2String(3));
		assertEquals("3.10", DoubleUtil.double2String(3.1));
		assertEquals("3.13", DoubleUtil.double2String(3.1345));
		assertEquals("3.18", DoubleUtil.double2String(3.1845));
	}

}
