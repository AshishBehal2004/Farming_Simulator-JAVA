package students;
import students.Field;
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
			
			else if (action.equals("plant"))
			{
				plant();
			}
			
//			else if (action.equals("w"))
//			{
//				wait();
//			}
		}
		System.out.println("thank you for playing. ");	
	}
	
	public void plant()
	{
		
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
