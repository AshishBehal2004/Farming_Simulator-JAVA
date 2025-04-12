package students;
import students.Field;
import java.util.Scanner;
public class Farm {
	
	private int fieldWidth;
	private int fieldHeight;
	private int balance;
	private Field field;

	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.balance = startingFunds;
		this.field = new Field(fieldWidth,fieldHeight);
	}
	
	public void run()
	{
		boolean quit = true;
		while (quit != false)
		{
			Scanner user = new Scanner(System.in);
			System.out.println(field.toString());
			System.out.println("Bank Balance: $"+balance+"\n");
			System.out.println("Enter your next action: ");
			System.out.print("  t x y: ");
			String sc = user.nextLine();
			System.out.print("  h x y: ");
			String sc1 = user.nextLine();
			System.out.println("  p x y: ");
			System.out.println("  s x y: ");
			System.out.println("  w: ");
			System.out.println("  q: ");
			
		}
		
		
	}
	
}
