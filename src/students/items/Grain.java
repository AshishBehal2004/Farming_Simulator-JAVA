package students.items;

public class Grain extends Food{
	
	private static int generationcount = 0;
	
	public Grain()
	{
		super(2,6,2);
		generationcount += 1;
	}
	
	public static int getGenerationCount()
	{
		return generationcount;
	}
	
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
