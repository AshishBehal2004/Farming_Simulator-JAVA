package students;
import students.Field;
import students.items.Item;

import java.util.Scanner;
public class Farm {
	
	private int fieldWidth;
	private int fieldHeight;
	private int balance;
	private Field field;
	Scanner user = new Scanner(System.in);
	String action;
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.balance = startingFunds;
		this.field = new Field(fieldWidth,fieldHeight);
	}
	
	boolean run = true;
	public void run()
	{
		while (run)
		{
			System.out.println(field.toString());
			System.out.println("Bank Balance: $"+balance+"\n");
			System.out.println("Enter your next action: ");
			System.out.println("  t x y: till");
			System.out.println("  h x y: harvest");
			System.out.println("  p x y: plant");
			System.out.println("  s: field summary");
			System.out.println("  w: wait");
			System.out.println("  q: quit");
			action = user.nextLine();
			
			if (action.equals("q"))
			{
				quit();
			}

			else if (action.equals("s"))
			{
				summary(); 
			}
			
			String [] parts = action.split(" ");		
			if (parts.length == 3 && parts[0].equals("p"))
			{
				int a = Integer.parseInt(parts[1]);
				int b = Integer.parseInt(parts[2]);
				
				Item item = field.get(a, b);
				if (item instanceof Soil)
				{
					System.out.println("Enter: \n"
							+ " - 'a' to buy an apple for $\n"
							+ " - 'g' to buy grain for ");
					action = user.nextLine();
					if(user.equals(a))
					{
						
					}
				}
				
				
				
			}
			
//			else if (action.equals("w"))
//			{
////				wait();
//			}
		}
		
		System.out.println("thank you for playing. ");	
	}
	
	
	
	public String summary()
	{
		return field.getSummary();
		
	}
	
//	public void wait()
//	{
//		field.tick();
//	}
	
	public boolean quit()
	{	
		run = false;
		return run;
	}
}
