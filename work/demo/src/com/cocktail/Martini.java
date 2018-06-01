package com.cocktail;

public class Martini implements Cocktail{

	@Override
	public String getRecipe() {
		String recp = "2 1/2 oz Gin Try it with Plymouth \n 1/2 oz Dry vermouth \n 1 dash Orange bitters \nGarnish: 1 Lemon twist	";
		return recp;
	}

	@Override
	public String getName() {
		return "Martini";
	}

}
