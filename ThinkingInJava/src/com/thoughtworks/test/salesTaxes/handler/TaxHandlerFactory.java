package com.thoughtworks.test.salesTaxes.handler;

public class TaxHandlerFactory {
	public static ITaxHandler getTaxHandler(String str){
		ITaxHandler result = null;
		if( str.equals("1") ){
			result = new TaxHandler1();
		} else if( str.equals("2") ){
			result = new TaxHandler2();
		}
		return result;
	}
}
