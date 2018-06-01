package com.cocktail;

public class Margarita implements Cocktail{

	@Override
	public String getRecipe() {
		String recp = "2 oz Blanco tequila\n"
				+ "1 oz Fresh lime juice\n"
				+ "1/2 oz Orange liqueur\n"
				+ "1/2 oz Agave syrup\n"
				+ "Garnish: Lime wheel Kosher salt\n";
		return recp;
	}

	@Override
	public String getName() {
		return "Margarita";
	}
	

}
