package com.nilshah.coffeemachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class items {

	Map<String, Integer> item;
	String name;
	double price;
	
	Inventory inventory;
	
	public items(String name, Inventory inventory)
	{
		this.inventory = inventory;
		this.name = name;
		item = new HashMap<String, Integer>();
		prepare();
		price = calculateCost();
		
	}

	public abstract void prepare();
	
	
	public DrinkMenu create()
	{
		DrinkMenu dm;
		
		if(isInStock())
		{
			dm = new DrinkMenu(name);
			
			for (Entry<String, Integer> ingredient : item.entrySet()) {
				for (int i = 0; i < ingredient.getValue(); i++) {
					dm = (inventory.get(ingredient.getKey())).addIngrediants(dm);
				}
			}
			dispenseCoffee();
			return dm;
		}
		else
		{
			outOfStock();
			return null;
		}
	}
	
	public void dispenseCoffee() {
		System.out.println("Dispensing: " + name);
	}
	
	public void outOfStock() {
		System.out.println("Out of Stock: " + name);
	}
	
	public  boolean isInStock() {
		for (Entry<String, Integer> ingredient : item.entrySet()) {
			if (!inventory.isEnough(ingredient.getKey(), ingredient.getValue())) {
				return false;
			}
		}
		return true;
	}
	
	public void addIngredient(String ingredient, int qty) {
		item.put(ingredient, qty);
	}
	
	public double getCost() {
		return price;
	}
	
	public double calculateCost()
	{
		double cost = 0;
		for (Entry<String, Integer> data : item.entrySet()) {
			for (int i = 0; i < data.getValue(); i++) {
				cost += inventory.getCost(data.getKey());
			}
		}
		return cost;
	}
	
}

class coffeeItems extends items
{

	public coffeeItems(Inventory inventory) {
		super("coffee", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("coffee", 3);
		addIngredient("sugar", 1);
		addIngredient("cream", 1);
		
	}
	
}

class decafecoffeeItems extends items
{

	public decafecoffeeItems(Inventory inventory) {
		super("decafecoffee", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("decafecoffee", 3);
		addIngredient("sugar", 1);
		addIngredient("cream", 1);
	}
	
}

class cafelatteItems extends items
{

	public cafelatteItems(Inventory inventory) {
		super("cafelattee", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("espresso", 2);
		addIngredient("stemedmilk", 1);
	}
	
}

class cafeamericanoItems extends items
{

	public cafeamericanoItems(Inventory inventory) {
		super("cafeamericano", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("espresso", 3);
	}
	
}

class cafemochaItems extends items
{

	public cafemochaItems(Inventory inventory) {
		super("cafemocha", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("espresso", 1);
		addIngredient("cocoa", 1);
		addIngredient("stemedmilk", 1);
		addIngredient("whippedcream", 1);
	}
	
}
class cappuccinoItems extends items
{

	public cappuccinoItems(Inventory inventory) {
		super("cappuccino", inventory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		addIngredient("espresso", 2);
		addIngredient("stemedmilk", 1);
		addIngredient("foamedmilk", 1);
	}
	
}


