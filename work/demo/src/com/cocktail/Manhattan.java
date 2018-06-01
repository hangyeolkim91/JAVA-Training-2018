package com.cocktail;

public class Manhattan implements Cocktail{

	@Override
	public String getRecipe() {
		String recp=" 2 dashes Angostura bitters\n"
				+ "1 dash Orange bitters\n"
				+ "2 oz Bourbon or rye\n"
				+ "1 oz Sweet vermouth\n"
				+ "Garnish: Brandied cherry\n";
		return recp;
	}

	@Override
	public String getName() {
		return "Manhattan";
	}

}
