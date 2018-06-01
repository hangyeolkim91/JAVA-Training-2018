package com.cocktail;

public class Daiquiri implements Cocktail {

	@Override
	public String getRecipe() {
		String recp = "2 oz Light rum\n"
				+ "3/4 oz Fresh lime juice\n"
				+ "3/4 oz Demerara sugar syrup\n"
				+ "Garnish: Lime twist\n";
		
		return recp;
	}

	@Override
	public String getName() {
		return "Daiquiri";
	}

}


 
