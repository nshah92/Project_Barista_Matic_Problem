package com.nilshah.coffeemachine;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
	
	Map<String, Integer> qty;
	Map<String, Ingredients> ingredient;

	
	public Inventory()
	{
		ingredient = new HashMap<String, Ingredients>();
		qty = new TreeMap<String, Integer>();
		
		addIngredientsToDatabase(new coffee());
		addIngredientsToDatabase(new decafecoffee());
		addIngredientsToDatabase(new sugar());
		addIngredientsToDatabase(new cream());
		addIngredientsToDatabase(new steamedmilk());
		addIngredientsToDatabase(new foamedmilk());
		addIngredientsToDatabase(new espresso());
		addIngredientsToDatabase(new cocoa());
		addIngredientsToDatabase(new whippedcream());

	}
	
	public void addIngredientsToDatabase(Ingredients ingredient)
	{
		if(!(this.ingredient.containsKey(ingredient.getName())))
		{
			this.ingredient.put(ingredient.getName(), ingredient);
			qty.put(ingredient.getName(), 10);
		}
	}
	
	public boolean isEnough(String ingredient, int qty)
	{
		if (this.ingredient.containsKey(ingredient)) {
			if (this.qty.get(ingredient) >= qty) {
				return true;
			}
			else {
				return false;
			}
		}
		else
		{
			System.out.println("Not Enough Ingrediants");
			return false;
		}
	}
	
	public Ingredients get(String key) {
		// TODO Auto-generated method stub
		
		if(isEnough(key, 1))
		{
			qty.put(key, qty.get(key) - 1);
			return this.ingredient.get(key).clone();
		}
		return null;
	}
	
	public double getCost(String key)
	{
		double price = 0.0;
		if(ingredient.containsKey(key))
		{
			price = ingredient.get(key).cost();
		}
		return price;
	}
	
	public void fillStock()
	{
		for (String ingredient : qty.keySet()) {
			qty.put(ingredient, 10);
		}
	}
	
	public void showStock()
	{
		System.out.println("Avaliable Stock");
		System.out.println(qty);
	}
}
