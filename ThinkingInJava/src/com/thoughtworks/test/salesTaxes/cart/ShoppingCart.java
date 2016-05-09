package com.thoughtworks.test.salesTaxes.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.test.salesTaxes.handler.ITaxHandler;
import com.thoughtworks.test.salesTaxes.handler.TaxHandlerFactory;
import com.thoughtworks.test.salesTaxes.product.IProduct;
import com.thoughtworks.test.salesTaxes.product.Product;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;

public class ShoppingCart {
    private Map<IProduct, ShoppingCartItem> items = null;
	private static int count = 0;
	private int seq ;
	private boolean isComputed = false;

    public ShoppingCart() {
        items = new LinkedHashMap<IProduct, ShoppingCartItem>();
        seq = ++count;
    }

    public synchronized void add(IProduct product) {
        if (items.containsKey(product)) {
            ShoppingCartItem scitem = (ShoppingCartItem) items.get(product);
            scitem.incrementQuantity();
        } else {
            ShoppingCartItem newItem = new ShoppingCartItem(product);
            items.put(product, newItem);
        }
    }

    public synchronized void remove(IProduct product) {
        if (items.containsKey(product)) {
            ShoppingCartItem scitem = (ShoppingCartItem) items.get(product);
            scitem.decrementQuantity();

            if (scitem.getQuantity() <= 0) {
                items.remove(product);
            }
        }
    }

    public synchronized List<ShoppingCartItem> getItems() {
        List<ShoppingCartItem> results = new ArrayList<ShoppingCartItem>();
        results.addAll(this.items.values());

        return results;
    }
    
	public void computeTax(){
		ITaxHandler cs = TaxHandlerFactory.getTaxHandler("1");
        for (Iterator i = getItems().iterator(); i.hasNext();) {
            ShoppingCartItem item = (ShoppingCartItem) i.next();
            IProduct bookDetails = (IProduct) item.getItem();
            item.getItem().computeTax();
//            double tax = cs.computeTax( bookDetails.getPrice(), p.getTaxRate() );
//            bookDetails.setTax(tax);
        }
		isComputed = true;
	}
    
    public synchronized double getTotal() {
    	double amount = 0.0;
    	amount = getTotalPrice() + getTotalTax();
    	return roundOff(amount);
    }

    public synchronized double getTotalPrice() {
        double amount = 0.0;

        for (Iterator i = getItems().iterator(); i.hasNext();) {
            ShoppingCartItem item = (ShoppingCartItem) i.next();
            IProduct bookDetails = (IProduct) item.getItem();

            amount += (item.getQuantity() * bookDetails.getPrice());
        }

        return roundOff(amount);
    }
    
    public synchronized double getTotalTax() {
        double amount = 0.0;

        for (Iterator i = getItems().iterator(); i.hasNext();) {
            ShoppingCartItem item = (ShoppingCartItem) i.next();
            IProduct bookDetails = (IProduct) item.getItem();

            amount += (item.getQuantity() * bookDetails.getTax());
        }

        return roundOff(amount);	
	}

    private double roundOff(double x) {
        long val = Math.round(x * 100); // cents

        return val / 100.0;
    }
    
    public String toString(){
		StringBuilder sb = new StringBuilder();
		if( !isComputed ){
			sb.append( "Input " + seq + "\n");
		}else{
			sb.append( "Output " + seq + "\n");
		}
        for (Iterator i = getItems().iterator(); i.hasNext();) {
            ShoppingCartItem item = (ShoppingCartItem) i.next();
            sb.append( item + "\n");
        }
		if( isComputed ){
			sb.append( "Sales Taxes: " + DoubleUtil.double2String(getTotalTax()) + "\n");
			sb.append( "Total: " + DoubleUtil.double2String(getTotal()) + "\n");
		}
		sb.append( "\n");
		return sb.toString();
    }

    public synchronized void clear() {
        items.clear();
    }
    
    protected void finalize() throws Throwable {
        items.clear();
    }
}
