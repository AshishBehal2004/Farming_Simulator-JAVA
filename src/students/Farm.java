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
	
	public void run()
	{
		boolean run = true;
		while (run)
		{
			System.out.println(field.toString());
			System.out.println("Bank Balance: $"+balance+"\n");
			System.out.println("Enter your next action: ");
			System.out.println("  t x y: ");
			System.out.println("  h x y: ");
			System.out.println("  p x y: ");
			System.out.println("  s: ");
			System.out.println("  w: ");
			System.out.println("  q: ");
			action = user.nextLine();
			
			if (action == "quit")
			{
				quit();
			}
//			break;
			else if (action == "field summary")
			{
				summary();
			}
		}
		System.out.println("thank you for playing. ");
		
	}
	public String summary()
	{
		return field.getSummary();
		
	}
	
	public boolean quit()
	{
		return true;
	}
}
