package students.items;

//Soil here is the child class that inherits everything from its parent
//class(Item). This class is later on used in Field.
public class Soil extends Item{

	public Soil() 
	{
		//Soil constructor that has super constructor which calls Item class
		//constructor in order to add necessary value in the arguments.
		super(Integer.MAX_VALUE,Integer.MAX_VALUE,0);
		
	}

	//toString method overriding its base class(Item) toString() method, and 
	//returning(displaying) the '.' symbol
	@Override
	public String toString() 
	{
		return ".";
	}

}
