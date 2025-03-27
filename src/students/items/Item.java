package students.items;

public abstract class Item {
	private int age = 0;
	private int maturation_age;
	private int death_age;
	private int monetary_value;
	
	//Constructor
	public Item() 
	{
		this.age = age;
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
		if (this.age >= this.death_age)
		{
			return true;
		}
		return false;
	}
	
	public int getValue()
	{
		if (this.age >= this.maturation_age)
		{
			return this.monetary_value;			
		}	
		return this.monetary_value;	
	}
	
	//This is toString going to be used by the child classes.
	public abstract String toString();
	
}
