package util;

import java.util.Comparator;

import objet.Pizza;

public class TriPizzaParDesignation implements Comparator<Pizza> {

	public int compare(Pizza o1, Pizza o2) {

		if (o1.getDesignation().compareTo(o2.getDesignation()) > 1)
		{
			return 1;
		} 
		else if (o1.getDesignation().compareTo(o2.getDesignation()) < 1)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	
}