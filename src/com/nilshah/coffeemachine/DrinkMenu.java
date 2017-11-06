package com.nilshah.coffeemachine;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DrinkMenu {

	private String drinkname;
	Map<String, items> recipes;
	
	public DrinkMenu(String name)
	{
		this.drinkname = name;
	}
	
	public DrinkMenu(Inventory inventory)
	{
		recipes = new TreeMap<String, items>();
		addrecipie(new coffeeItems(inventory));
		addrecipie(new decafecoffeeItems(inventory));
		addrecipie(new cafelatteItems(inventory));
		addrecipie(new cafeamericanoItems(inventory));
		addrecipie(new cafemochaItems(inventory));
		addrecipie(new cappuccinoItems(inventory));
	}
	
	public void showMenu()
	{
		System.out.println("Menu:");
		int i = 0;
		for(Entry<String, items> data : recipes.entrySet())
		{
			String price = String.format("%.2f", data.getValue().getCost());
			System.out.println( (i + 1 ) + "," + data.getKey() + "," + "$" + price + "," + data.getValue().isInStock() );
			i++;

		}
	}
	
	public DrinkMenu makeDrink(int index) {
		if (index < recipes.size()) {
			Iterator<items> it = recipes.values().iterator();
			for (int i = 0; i < index; i++) {
				it.next();
			}
			return it.next().create();
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void addrecipie(items item)
	{
		recipes.put(item.name, item);
	}
	
	public String getDescription() {
		return drinkname;
	}
}
