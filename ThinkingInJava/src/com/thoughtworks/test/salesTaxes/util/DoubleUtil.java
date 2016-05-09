package com.thoughtworks.test.salesTaxes.util;

import java.text.DecimalFormat;

public class DoubleUtil {
	public static String double2String(double d) {
		String ds = String.valueOf(d);
		int indx1 = ds.indexOf(".");
		if (indx1 == -1) {
			return ds + ".00";
		} else if (ds.length() - indx1 < 3) {
			return ds + "0";
		} else if (ds.length() - indx1 == 3) {
			return ds;
		} else {
			return ds.substring(0, ds.indexOf(".") + 3);
		}
	}

//	public static String double2String(double d, int fNumber) {
//		if (fNumber < 0)
//			fNumber = 0;
//
//		String pattern = null;
//		switch (fNumber) {
//		case 0:
//			pattern = "#0"; //$NON-NLS-1$
//			break;
//		default:
//			pattern = "#0."; //$NON-NLS-1$
//			StringBuffer b = new StringBuffer(pattern);
//			for (int i = 0; i < fNumber; i++) {
//				b.append('#');
//			}
//			pattern = b.toString();
//			break;
//
//		}
//		DecimalFormat formatter = new DecimalFormat();
//		formatter.applyPattern(pattern);
//		String value = formatter.format(d);
//		return value;
//	}
}
