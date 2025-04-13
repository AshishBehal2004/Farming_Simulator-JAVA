package students.items;

public class Weed extends Item
{	
	//Weed here is the child class that inherits everything from its parent
	//class(Item). This class is later on used in Field class.
	public Weed()
	{
		//Weed constructor that has super constructor which calls Item class
		//constructor in order to add necessary value in the arguments.
		//I used Integer.MAX_VALUE since it holds the largest value, since in 
		//the assignment we are told to have an infinite maturation and death age
		super(Integer.MAX_VALUE,Integer.MAX_VALUE,-1);
	}

	//toString method overriding its base class(Item) toString() method, and 
	//returning(displaying) the '#' symbol
	@Override
	public String toString() 
	{
		return "#";
	}

}
