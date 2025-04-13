package students;

//Using the random class which will be used for the weed creation
import java.util.Random;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.Weed;
import students.items.UntilledSoil;


public class Field {
	/*field takes height, width and field(which is a 2 dimensional Item object) as private varaible
	apart from random(which is initialized and created) rest above three private variables are just initialized
	
	
	*/
	private int height;
	private int width;
	private Item [][] field ;
	Random random = new Random();
	// Field's constructor which takes height(integers) and width(integers) as parameters
	//then sets feild's heigght and width size and creating new item(by passing height 
	//and width into field as its parameters which points to item location in the field.
	public Field(int height, int width)
	{
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		
		//main nested for loop which goes through every single height in field, and the second 
		// which goes through every single width in field(to make sure every corner in field is covered)
		// and plants soil on each of those location.
		for(int i=0;i<height;i++)
		{
			for (int j=0;j<width;j++)
			{
				this.field[i][j] = new Soil();
			}
		}
	}
	
	/*This tick is reponsible for increasing evry item's age. Here i used the same logic(on line 36)
	to loop through every location in the field and calling tick(). The role of first if is to 
	check if Soil(directly checking it to SOil class here) is on every location, if true then
	there's 20% chance for the location to turn into Weed(here it makes the new Weed object which 
	replaces the current Soil object. However there is a slight error in the way
	I did, and that is whenever i call this, it puts a lot of weed on the field, which should not be done.
	I tried fixing by replacing 1 with 0, but the issue still arises.
	
	*/
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
	
	/*This below till method which takes row and column as its parameters is responsible for putting 
	new soil in the current location on the field. */
	public void till(int row, int column)
	{
		field[row][column] = new Soil();
	}
	
	/*plant method which takes row, column and item(this here is the Item class object)as its parameters is 
	  responsible for planting the item on the current location in the field 
	 . */
	public void plant(int row,int column,Item item)
	{
		field[row][column] = item;
	}
	
	/*The get which is responsible for returing item copy instead of original item(which i was doing in  
	  earlier stages). made a copy of the original item and gave it the name originalcopy, the first checks 
	  if that copy is Soil(directyl checks it with the Soil class here), if it is then makes a copy of the soil
	  as well and sets its age by calling originalcopy's(which is the copy of the current original Item object in the field) age
	  and return the copysoil. 
	  
	  The second if checks for weed, makes the copy of it as well and sets its age(by calling the originalcopy getAge() method)
	  and return copyweed(basically the copy of the original weed) as well.
	 
	 
	 * */
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
	
	/*
	 the getvalue method here retrieves every single items total monetary value, here i used the similar looping through the field
	 logic which did in above methods, but the only difference is I used counter to increase the value of each item in the field 
	 so that it gives me their total monetary vale at the end by returning the count(which sums all the items getValue())
	 
	 
	  */
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
	
	/*This getSummary() method is crucial for displaying the field and all the  print statements, made four count variables
	 which counts evry item and food: Apple(for countApples),grain(for countGrain),Soil(for countSOil),UntilledSoil(for countUntilledSoil)
	 and Weed(for countWeed), there is also one more: the totalValue(responsible for counting the total price of the item by calling 
	 item's getValue() and adding that onto totalValue.And then there is summary String variable which uses String.Format(basically for aligning 
	 as i could'nt find anything else better than this) to display Apples, Grain, Soil, Weed, Untilled Soil, their cost, and hoe many apples
	 and grain created individually. Then shows it by returning the String summary.
	 */
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
		String summary = String.format("Apples:%7d\n",countApples);
				summary += String.format("Grain:%8d\n",countGrain);
				summary += String.format("Soil:%10d\n",countSoil);
				summary += String.format("Untilled:%5d\n",countUntilledSoil);
				summary += String.format("Weed:%10d\n",countWeed);
				summary += String.format("For a total of:$%10d\n",totalValue);
				summary += String.format("Total apples created:%4d\n",Apples.getGenerationCount());
				summary += String.format("Total grain created:%5d\n",Grain.getGenerationCount());
				
		return summary;
	}
	
	/*
	 toString method which overrides the parent class abstract toString method. takes an empty string called fieldsize
	 ,the first for loop is responsible for displaying the numbers as heading on the field(adds i(which increase as long
	 as its less than width and adds a empty space which is shown as: " ". out of the loop it jumps to nextline.
	 The second for loop is a nested for loop, which first loops through the field's height, add int and space(" ")
	 the second nested for loop, loops through every column but this time it adds the item symbol(by calling every item's
	 toString method) on every location of the field.then, at the end of the second nested for loop it adds next line(shown by: "\n").
	 basically adding every symbol and showing the field heading(like how long by numbers horizontally and vertically) on to the field
	 and returning the fieldsize at the end of nested for loop.
	 */
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
