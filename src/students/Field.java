package students;

import java.util.Random;
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
