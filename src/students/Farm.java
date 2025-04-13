package students;
//Imports Field class to use its method
import students.Field;
import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.Food;

import java.util.Scanner;
public class Farm {
	//private variable
	private int fieldWidth;
	private int fieldHeight;
	private int balance;
	
	//private field object which is declared but initialized inside the constructor.
	private Field field;
	//Scanner object for taking input from the user
	Scanner user = new Scanner(System.in);
	//this action variable is decalred but its actual used after all the multiple print stateents at line 46 
	String action;
	//Constructor taking three arguments to make a field and funds(which will be assigned to the user in later code below.
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		// initializing and setting the farm fields, funds and creating a new field.
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.balance = startingFunds;
		this.field = new Field(fieldWidth,fieldHeight);
		
	}
	
	//boolean to keep the while loop running
	boolean run = true;
	//main method which does not return anything
	public void run()
	{
		//Most improant part of this file. while loop which keeps on running until its false.
		while (run)
		{
			//multiple statements to be shown to the user, the below first statement calls field class toString method
			System.out.println(field.toString());
			System.out.println("Bank Balance: $"+balance+"\n");
			System.out.println("Enter your next action: ");
			System.out.println("  t x y: till");
			System.out.println("  h x y: harvest");
			System.out.println("  p x y: plant");
			System.out.println("  s: field summary");
			System.out.println("  w: wait");
			System.out.println("  q: quit");
			//takes whatever from above option is entered by the user.
			action = user.nextLine();
			
			//checks if the user entered q and calls quit method(which is created below at last)
			if (action.equals("q"))
			{
				quit();
			}
			//checks if the user entered s and calls summary() 
			else if (action.equals("s"))
			{
				summary(); 
			}
			
			//this is array which takes strings enterd by user and splits them into array of seprated string by using .split 
			String [] parts = action.split(" ");
			//another main block that checks if the length of words enterd by user is 3 and if the first word is p
			if (parts.length == 3 && parts[0].equals("p"))
			{
				//below two ints convert the string numbers entered by user into int.
				int a = Integer.parseInt(parts[1]);
				int b = Integer.parseInt(parts[2]);
				
				//this below parts stores(whatever item is stored on the exact location) into item object. 
				Item item = field.get(a, b);
				//checks if the item(on exact field location) is soil(here this is the class Soil which it is comparing with)
				if (item instanceof Soil)
				{
					// if it is soil then display this below line to user to enter either 'a' or 'g' and takes the user input. 
					System.out.println("Enter: \n"
							+ " - 'a' to buy an apple for $2\n"
							+ " - 'g' to buy grain for $1 ");
					
					String choice = user.nextLine();
					/*storing the taken user input in choice(which is local to run method)
					  and checks if it is a and the balance(the funds given to user in beginning)
					  is more than equal to 2, then plant the apples(here it calls field's plant method on the field object which
					  i made at the top and takes in given arguments for planting(I created new apples direvcty without initializing at top
					  since  each apple created should be new and separted.And then it deducts the balance by 2(since the cost of buying
					   mentioned in print staement is 2*/
					if(choice.equals("a"))
					{
						if (balance >= 2)
						{
							field.plant(a, b, new Apples());
							balance -=2;
						}
						//else parts executes when balance is less than 2 and prints the message
						else
						{
							System.out.println("Need to $2 to plant Apple");
						}
					}
					/*this else part below is for grain and the logic is similar to apple,
					 *  if user enters g and if balance is more than equal to 1 plant the
					 *   grain on the field(position obtained by a and b) and reduce the balance by 1*/
					else 
						if (choice.equals("g"))
					{
						if (balance >= 1)
						{
							field.plant(a, b, new Grain());
							balance -= 1;
						}
						//similarly this else parts executes when balance is less than 1 and prints the message
						else 
						{
							System.out.println("Need to $1 to plant Grain");							
						}
					}
					/*this below else happens when user enters something else instead of a and g and prints the message */
						else
							if (choice != "a" || choice != "g")
							{
								System.out.println("Invalid choice, Enter 'a' or 'g'");
								String choice2 = user.nextLine();
							}
				}
				//else parts executes when the item is not soil(on line 78) and prints the message
				else
				{
					System.out.println("Sorry Items can only be Planted in Soil");
				}
			}
			/* this below part is to till soil, the logic is similar to plant but the differnce is, if the first element of 
			 array(created above on line 67) is 't'
			  convert the numbers(which are string) which are on second and third element in array(created above on line 67) to int,
			  and till(by calling Field class till) on the exact location(obtained from user and converted into int) of the field  */
			else if (parts.length == 3 && parts[0].equals("t"))
			{
				int a = Integer.parseInt(parts[1]);
				int b = Integer.parseInt(parts[2]);
				
				field.till(a, b);
			}
			/*Also similar to the plant logic, but checks if the first element of array(created above on line 67) is h. 
		      convert the second and third element(begin as a word then splitted and stored in the string array) into
		      int a and b respectively. item variable(which is an item object) stores the copy of field location(whatever 
		      item is on that field) into item.
		
			*/
			else if (parts.length == 3 && parts[0].equals("h") )
			{
				int a = Integer.parseInt(parts[1]);
				int b = Integer.parseInt(parts[2]);
				Item item = field.get(a, b);
				/*Checks if the item is food(directly checking it to food class) and its maturation age is less than
				  current age, then add the value(obtained by calling items getter method which is getValue) in balance
				  and till the field(by clearing the field after harvest and setting it to new soil)*/
				if (item instanceof Food && item.getMaturationAge() <= item.getAge())
				{
					balance += item.getValue();
					field.till(a, b);
				}
				
			}
			
			//this below if matures the field by calling tick(which is part of Field class)
			else if (action.equals("w"))
			{
				field.tick();
			}
		}
		//As mentioned in assignment, after every action increase the age, hence the tick is 
		//responsible for increasing the age.
		field.tick();
		//last statementat the end of the loop which displays print message when run becomes false.
		System.out.println("thank you for playing. ");	
	}
	
	
	//prints the summary(here it calls getSummary of field class) of the field
	public void summary()
	{
		System.out.println(field.getSummary());
		
	}
	

	//This is responsible for exiting the while loop, used above at line 58 when the user enter q, this method is called.
	public boolean quit()
	{	
		run = false;
		return run;
	}
}
