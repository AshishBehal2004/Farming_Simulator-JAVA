package students.items;

//UntilledSoil here is the child class that inherits everything from its pare
//class(Item). This class is later on used in Field.
public class UntilledSoil extends Item{
	//UntilledSoil constructor that has super constructor which calls Item class
	//constructor in order to add necessary value in the arguments.
	public UntilledSoil()
	{
		super(Integer.MAX_VALUE,Integer.MAX_VALUE,-1);
	}

	//toString method overriding its base class(Item) toString() method, and 
	//returning(displaying) the '/' symbol
	@Override
	public String toString() {
		return "/";
	}

}
