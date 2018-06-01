package com.cocktail;

public class Punch implements Cocktail {

	@Override
	public String getRecipe() {
		String recp ="4 Lemons' peels\n"
				+ "1 cup Fine-grained raw sugar\n"
				+ "8 oz Lemon juice\n"
				+ "24 oz VSOP cognac or armagnac\n"
				+ "8 oz Dark, strong Jamaican rum\n"
				+ "40 oz Cold water\n"
				+ "Garnish: 1 Nutmeg\n";
		return recp;
	}

	@Override
	public String getName() {
		return "Punch";
	}
	

}




	


