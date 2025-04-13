package students.items;

/* This right here is the child class that is inheriting  parent class(Food) method and variables.
 
   */
public class Apples extends Food {
	// private static variablle of type int. It is static so that one counter gets shared among all 
	//the apples created, earlier i was doing it without static which caused every apple object to
	//have their own separate counter instead of sharing one counter among all the apple objects created.
	private static int generationCount = 0;
	
	public Apples()
	{
		/*  the super constructor here, which calls food items constructor(which takes maturation_age, 
		  death_age and monetary_value as the arguments), and generationcount which increases every time 
		  a new apple is created.	 
		*/
		super(3,5,3);
		generationCount+=1;
	}
	
	public static int getGenerationCount()
	{
		return generationCount;
	}

	@Override
	/*
	 toString method overriding the Food(which inturn inherits it from Items class) method.
	 returns small a if the age is less than 3, otherwise capital A(which handles the rest else cases)
	 
	 */
	public String toString() 
	{
		if (this.getAge() < 3)
		{
			return "a";
		}
		else {
			
			return "A";
		}
	}
	
}
