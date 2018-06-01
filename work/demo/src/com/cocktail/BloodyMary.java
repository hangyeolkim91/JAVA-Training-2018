package com.cocktail;

public class BloodyMary implements Cocktail {

	@Override
	public String getRecipe() {
		String recp="1 Lemon wedge\n 1 Lime wedge\n 2 oz Vodka\n 4 oz Tomato juice\n 2 dashes Tabasco sauce\n 2 tsp Prepared horseradish\n 2 dashes Worcestershire sauce"
				+ "1 pinch Celery salt\n"
				+ "1 pinch Ground black pepper\n"
				+ "1 pinch Smoked paprika\n";
		

		return recp;
	}

	@Override
	public String getName() {
		return "Boody Mary";
	}

	
}
