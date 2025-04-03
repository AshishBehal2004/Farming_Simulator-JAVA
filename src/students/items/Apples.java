package students.items;

public class Apples extends Food {
	
	private int generationCount = 0;
	
	public Apples()
	{
		super(3,5,3);
		this.generationCount = generationCount;
		
	}
	
	public int getGenerationCount()
	{
		return generationCount;
	}

	@Override
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
