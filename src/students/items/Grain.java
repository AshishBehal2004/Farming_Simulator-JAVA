package students.items;

/*Grain class is the child class of Food(which is its parent class), it inherits 
  all the methods and variables from its parent class(Food).
  generationcount which is a private static variable of int type,
  the reason for this variable beign static is same as the apple class generationcount.
 */
public class Grain extends Food{
	
	private static int generationcount = 0;
	
	// Super constructor here calls the Food constructor in order to add necessary arguments
	//which are specific to this Grain class, and increases the generationcount by 1 after the
	//creation of every Grain.
	public Grain()
	{
		super(2,6,2);
		generationcount += 1;
	}
	
	// getter for generationcount which returns integer(int this, it returns gernerationcount)
	public static int getGenerationCount()
	{
		return generationcount;
	}
	
	//toString being overridden, since this class inherits everything from its parent class(Food in this case,
	//that also inherits everything from Item), returns small g if the age is less than 2, otherwise capital G.
	//earlier i was doing else if, which was causing me error, then i removed and i just returned the string as it is.
	@Override
	public String toString() 
	{
		if (this.getAge() < 2)
		{
			return "g";
		}
		return "G";
	}
	
}
