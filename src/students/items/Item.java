package students.items;

public abstract class Item {
	private int age = 0;
	private int maturation_age;
	private int death_age;
	private int monetary_value;
	
	//Constructor
	public Item(int maturation_age, int death_age, int monetary_value) 
	{
		this.maturation_age = maturation_age;
		this.death_age = death_age;
		this.monetary_value = monetary_value;
		
	}
	
	//Setter for Age
	public void setAge(int age)
	{
		this.age= age;
	}
	
	public void tick() 
	{
		this.age += 1;
	}
	
	public boolean died()
	{
		return this.age > this.death_age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public int getValue()
	{
		if (this.age >= this.maturation_age)
		{
			return this.monetary_value;			
		}	
		return 0;	
	}
	//.equals method which will first override the default .equals method. 
	//Then in the method it takes one parameter otherObj which is an 
	//Object(allows any types of object to passed in order to compare.).
	//The if block uses instanceof to check if the otherObj is instance of the Item 
	//class(or its subclasses(for eg: Food, Weed etc). if true then convert otherObj into Item
	//and check if Item's age, maturation_age, death_age,, monetary_value matches the 
	//otherObj's(which is also now item after the conversion) age, maturation_age, death_age,
	//monetary_value. else exit the if block and return false(As it happens when either when is not matched).
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
	
	//This is toString going to be used by the child classes.
	public abstract String toString();
	
}
