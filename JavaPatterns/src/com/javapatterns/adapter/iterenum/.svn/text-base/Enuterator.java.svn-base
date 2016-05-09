package com.javapatterns.adapter.iterenum;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Enumeration;

public class Enuterator implements Iterator
{
	Enumeration enu;

    public Enuterator(Enumeration enu)
    {
		this.enu = enu;
    }

    public boolean hasNext()
    {
		return enu.hasMoreElements();
    }

    public Object next() throws NoSuchElementException
    {
        return enu.nextElement();
    }

    public void remove()
    {
		throw new UnsupportedOperationException();
    }

}
