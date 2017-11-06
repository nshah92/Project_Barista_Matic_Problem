package com.nilshah.coffeemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunMachine {

	public static void main(String args[]) throws IOException
	{
		boolean flag = false;
		Inventory inventory = new Inventory();
		DrinkMenu dm = new DrinkMenu(inventory);

		inventory.showStock();
		dm.showMenu();


		while(!flag)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number:");
			String number = br.readLine().toLowerCase();
			char ch = 0;

			if(number.length() == 1)
				ch = number.charAt(0);
			else
				System.out.println("single digit input required");


			switch(ch)
			{
			case 'r':
					inventory.fillStock();
					inventory.showStock();
					dm.showMenu();
					break;
			case 'q':
					flag = true;
					break;
			case '1':
					dm.makeDrink(0);
					inventory.showStock();
					dm.showMenu();
					break;
			case '2':
				dm.makeDrink(1);
				inventory.showStock();
				dm.showMenu();
				break;
			case '3':
				dm.makeDrink(2);
				inventory.showStock();
				dm.showMenu();
				break;
			case '4':
				dm.makeDrink(3);
				inventory.showStock();
				dm.showMenu();
				break;
			case '5':
				dm.makeDrink(4);
				inventory.showStock();
				dm.showMenu();
				break;
			case '6':
				dm.makeDrink(5);
				inventory.showStock();
				dm.showMenu();
				break;
			default:
				System.out.println("Invalid Selection");
				inventory.showStock();
				dm.showMenu();
				break;
			}

		}
	}

}
