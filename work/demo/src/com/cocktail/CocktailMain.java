package com.cocktail;

import java.util.Random;

public class CocktailMain {

	public static void main(String[] args) {

		Random rd = new Random();
		Cocktail[] ct ={new Martini(), new BloodyMary(), new Manhattan(), new Daiquiri(), new Margarita(), new Punch()}; 
		int n = rd.nextInt(6);
		System.out.println("Random Cocktail Recipe!! ");
		System.out.println("Your Lucky Number is "+ n + "!!");
		System.out.println("And your CockTail is " + ct[n].getName());
		System.out.println("The Recipe is\n");
		System.out.println(ct[n].getRecipe());
	}

}
