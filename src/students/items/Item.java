package students.items;

//Abstract class whose method will be used in the subclass: Food, Soil, UntilledSoil and Weed
public abstract class Item {
	//private variable with age variable set to default value
	private int age = 0;
	private int maturation_age;
	private int death_age;
	private int monetary_value;
	
	//Constructor that passes three aruguments which will be used throughout the code in different classes
	public Item(int maturation_age, int death_age, int monetary_value) 
	{
		this.maturation_age = maturation_age;
		this.death_age = death_age;
		this.monetary_value = monetary_value;
	}
	
	//Setter for private variable Age
	public void setAge(int age)
	{
		this.age= age;
	}
	
	//tick method which increases the age 
	public void tick() 
	{
		this.age += 1;
	}
	
	//died method responsible for returning true or false after checking if age is more than death age
	public boolean died()
	{
		return this.age > this.death_age;
	}	
	
	//getter for private variable age
	public int getAge()
	{
		return this.age;
	}
	
	//getter for private variable getMaturationAge
	public int getMaturationAge()
	{
		
		return this.maturation_age;
	}
	
	/*getter for private variable monetary value, checks and returns monetary value
	if age is greater than and equals to maturation age */
	public int getValue()
	{
		if (this.age >= this.maturation_age)
		{
			return this.monetary_value;			
		}	
		return 0;	
	}
	/*.equals method which will first override the default .equals method. 
	Then in the method it takes one parameter otherObj which is an 
	Object(allows any types of object to be passed in order to compare.).
	The if block uses instanceof to check if the otherObj is instance of the Item 
	class(or its subclasses(for eg: Food, Weed etc). if true then convert otherObj into Item
	and check if Item's age, maturation_age, death_age,, monetary_value matches the 
	otherObj's(which is also now item after the conversion) age, maturation_age, death_age,
	monetary_value. else exit the if block and return false(As it happens when either when is not matched).
	*/ 
	@Override
	public boolean equals(Object otherObj)
	{
		if (otherObj instanceof Item)
		{
			Item item = (Item) otherObj;
			return this.age == item.age &&
				   this.maturation_age == item.maturation_age &&
				   this.death_age == item.death_age &&
				   this.monetary_value == item.monetary_value;
		}
		return false;
	}
	
	//This is toString going to be used by the child classes: from food(since food inherits from Item.
	public abstract String toString();
	
}
