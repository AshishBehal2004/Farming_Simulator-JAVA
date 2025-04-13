package students.items;
//The Food class here is an abstract child class which inherits 
//all the methods and variables from its parent class that is Item
public abstract class Food extends Item 
{
	//Food's constructor which have super constructor that calls 
	//Item's constructor (which takes maturation_age, death_age and
	//monetary_value as its arguments. This class is later used in 
	//its child classes: Grain and Apple, to be able to inherit all 
	// methods(specifically constructor) and variables from parent class(Food).
	public Food(int maturation_age, int death_age, int monetary_value)
	{
		super(maturation_age, death_age, monetary_value);
		
	}
	

}
