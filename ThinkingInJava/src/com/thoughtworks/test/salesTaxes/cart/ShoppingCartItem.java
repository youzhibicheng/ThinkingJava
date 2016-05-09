package com.thoughtworks.test.salesTaxes.cart;

import com.thoughtworks.test.salesTaxes.product.IProduct;
import com.thoughtworks.test.salesTaxes.product.Product;
import com.thoughtworks.test.salesTaxes.util.DoubleUtil;

public class ShoppingCartItem {
    IProduct item;
	int quantity;

    public ShoppingCartItem(IProduct anItem) {
        item = anItem;
        quantity = 1;
    }

    public void incrementQuantity() {
        quantity++;
    }
    public void decrementQuantity() {
        quantity--;
    }
    
    public IProduct getItem() {
		return item;
	}
	public void setItem(IProduct item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString(){
		String result = quantity + " " + item + " at " + DoubleUtil.double2String( quantity * (item.getPrice()*100 + item.getTax()*100)/100 );
		return result;
	}
}
