package com.headfirstoop;

public class GuitarSpec {
	private Builder builder;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	private String model;
	private int numStrings;


	/*	@Override
	public boolean equals(Object arg0) {
		GuitarSpec gs = (GuitarSpec) arg0;
		if( this.builder == gs.builder && this.type == gs.type && this.backWood == gs.backWood && this.topWood == gs.topWood &&
				this.model.equalsIgnoreCase(gs.model) && this.numStrings == gs.numStrings)
			return true;
		else
			return false;

	}*/


	public GuitarSpec( Builder builder, String model, Type type,
			Wood backWood, Wood topWood, int numStrings){
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.numStrings = numStrings;
	}

	public boolean matches(GuitarSpec otherSpec){
		
		if(builder != otherSpec.getBuilder())
			return false;

		String model = otherSpec.getModel();
		if( (model != null) && (!model.equals("")) && (!model.equalsIgnoreCase(otherSpec.getModel())))
			return false;

		if( type != otherSpec.getType())
			return false;

		if( backWood != otherSpec.getBackWood())
			return false;

		if( topWood != otherSpec.getTopWood())
			return false;

		return true;
	}

	public Builder getBuilder(){
		return builder;
	}
	public String getModel(){
		return model;
	}
	public Type getType(){
		return type;

	}
	public Wood getTopWood(){
		return topWood;
	}
	public Wood getBackWood(){
		return backWood;
	}
	public int getNumString(){
		return numStrings;
	}

}
