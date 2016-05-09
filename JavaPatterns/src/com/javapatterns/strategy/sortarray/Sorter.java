package com.javapatterns.strategy.sortarray;

public class Sorter
{
    public void sort()
    {
	    sortStrategy.sort();
    }

    //make sure we should have this set method
    //or have constructor like Sorter(SortStrategy sortStrategy)
    public void setSortStrategy(SortStrategy sort)
    {
     	this.sortStrategy = sort;
    }
    /**
     * @link aggregation
     * @directed 
     */
    private SortStrategy sortStrategy;
}
