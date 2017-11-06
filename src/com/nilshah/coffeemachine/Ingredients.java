package com.nilshah.coffeemachine;

public abstract class Ingredients extends DrinkMenu {

	DrinkMenu drinkmenu;
	double price;
	
	public Ingredients(String name, double price) {
		super(name);
		this.price = price;
	}
	
	public String getDescription()
	{
		return drinkmenu.getDescription(); 
	}
	
	public String getName()
	{
		return super.getDescription(); 
	}
	
	
	public DrinkMenu addIngrediants(DrinkMenu drinkmenu)
	{
		this.drinkmenu = drinkmenu;
		return this;
	}

	public double cost()
	{
		return price;
	}
	
	public abstract Ingredients clone();

}

class coffee extends Ingredients
{
	public coffee() {
		super("coffee", 0.75);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new coffee();
	}	
}

class decafecoffee extends Ingredients
{
	public decafecoffee() {
		super("decafecoffee", 0.75);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new decafecoffee();
	}
}

class sugar extends Ingredients
{
	public sugar()
	{
		super("sugar",0.25);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new sugar();
	}
}
class cream extends Ingredients
{
	public cream()
	{
		super("cream",0.25);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new cream();
	}
}
class steamedmilk extends Ingredients
{
	public steamedmilk()
	{
		super("stemedmilk",0.35);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new steamedmilk();
	}
}

class foamedmilk extends Ingredients
{
	public foamedmilk()
	{
		super("foamedmilk",0.35);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new foamedmilk();
	}
}

class espresso extends Ingredients
{
	public espresso()
	{
		super("espresso",1.10);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new espresso();
	}
}

class cocoa extends Ingredients
{
	public cocoa()
	{
		super("cocoa",0.90);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new cocoa();
		}
}

class whippedcream extends Ingredients
{
	public whippedcream()
	{
		super("whippedcream",1.00);
	}

	@Override
	public Ingredients clone() {
		// TODO Auto-generated method stub
		return new whippedcream();
	}
}

