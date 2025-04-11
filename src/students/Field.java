package students;

import java.util.Random;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.Weed;
import students.items.UntilledSoil;


public class Field {
	
	private int height;
	private int width;
	private Item [][] field ;
	Random random = new Random();

	public Field(int height, int width)
	{
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		
		for(int i=0;i<height;i++)
		{
			for (int j=0;j<width;j++)
			{
				this.field[i][j] = new Soil();
			}
		}
	}
	
	
	public void tick()
	{
		for (int i =0; i<height; i++)
		{	for (int j =0; j<width;j++)
		{
			field[i][j].tick();	
			
			if (field[i][j] instanceof Soil)
			{
				if (random.nextInt(5) == 1)
				{
					field[i][j] = new Weed();
				}
			}
			
			if (field[i][j].died())
			{
				field[i][j] = new UntilledSoil();
			}
		}
	}
	}
	
	
	public void till(int row, int column)
	{
		field[row][column] = new Soil();
	}
	
	
	public void plant(int row,int column,Item item)
	{
		field[row][column] = item;
	}
	
	
	public Item get(int row,int column)
	{
		Item originalcopy = field[row][column];
		if (originalcopy instanceof Soil)
		{
			Soil copySoil = new Soil();
			copySoil.setAge(originalcopy.getAge());
			return copySoil;
		}
		else if (originalcopy instanceof Weed)
		{
			Weed copyweed = new Weed();
			copyweed.setAge(originalcopy.getAge());
			return copyweed;
		}
		return originalcopy;
	}
	
	public int getValue()
	{
		int count = 0;
		
		for(int i=0;i< height;i++)
		{
			for (int j=0 ;j<width;j++)
			{
				Item item = field[i][j];
				count += item.getValue();
			}
		}
		return count;
	}
	
	public String getSummary()
	{
		int countApples = 0; 
		int totalValue = 0;
		
		int countGrain = 0; 
		int countSoil = 0; 
		int countUntilledSoil = 0; 
		int countWeed = 0;
		
		for (int i=0;i<height;i++)
		{
			for (int j=0;j<width;j++)
			{
				Item item = field[i][j];
				if (item instanceof Apples)
				{
					countApples ++;
					
				}
				else if (item instanceof Grain)
				{
					countGrain++;
					
				}
				else if (item instanceof Soil)
				{
					countSoil++;
				}
				else if (item instanceof UntilledSoil)
				{
					countUntilledSoil++;
				}
				else if (item instanceof Weed)
				{
					countWeed++;
				}
				totalValue += item.getValue();
			}
			
		}
//		"%d/n%d/n%d/n%d/n%d/n"
		String summary = "Apples: "+countApples+"\n"+"Grain: "+countGrain+"\n"+"Soil: "+countSoil+"\n"+"UntilledSoil: "+countUntilledSoil+"\n"+"Weed: "+countWeed+"\n"+"For a total of: "+totalValue+"\n"+Grain.getGenerationCount();
		return summary;
	}
	
	@Override
	public String toString()
	{	
		String fieldsize = " ";
		
		for (int  i = 1; i<width;i++)
		{
			fieldsize += i + " ";
		}
		fieldsize += "\n";
		
		
		for (int j=1;j< height;j++)
		{
			fieldsize += j + " ";
			for (int z=0;z<width;z++)
			{
				fieldsize += field[j][z].toString();
			}
			fieldsize += "\n";
		}
		return fieldsize;
	}
}
