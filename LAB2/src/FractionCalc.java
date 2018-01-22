import java.util.*;
import java.util.Scanner;

public class FractionCalc 
{
	private Fraction left;
	private Fraction right;
	private char operator;
	
	private static String regex = "-?[0-9]+[ \t]*/[ \t]*-?[0-9]+[ \t]*[+-/\\*][ \t]*-?[0-9]+[ \t]*/[ \t]*-?[0-9]+";
	
	public FractionCalc(String input)
	{
		StringTokenizer parser = new StringTokenizer(input);
		ArrayList<String> arr = new ArrayList<String>();
		
		// Trim the leading and trailing spaces of the input string
		input = input.trim();
		
		// Make sure the input string is a valid fraction arithmetic expression
		if (!input.matches(regex))
		{
			System.err.println("Error: the input is not a valid fraction arithmetic expression.");
			System.exit(1);
		}
		
		// Split the string and store them into an array list
		while (parser.hasMoreTokens())
		{
			///String token = parser.nextToken();
			arr.add(parser.nextToken());
		}
		
		this.left = new Fraction(Integer.parseInt(arr.get(0)), Integer.parseInt(arr.get(2)));
		this.right = new Fraction(Integer.parseInt(arr.get(4)), Integer.parseInt(arr.get(6)));
		this.operator = arr.get(3).charAt(0);
	}
	
	public Fraction evaluate()
	{
		Fraction result = null;
		
		switch(this.operator)
		{
			case '+':
				result = this.left.add(this.right);
				break;
			case '-':
				result = this.left.sub(this.right);
				break;
			case '*':
				result = this.left.mult(this.right);
				break;
			case '/':
				result = this.left.div(this.right);
				break;
			default:
				System.err.println("Error: invalid operator.");
				System.exit(1);
				break;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		// Prompt and read the user input
		System.out.print("Please enter a fraction expression: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("");
		scanner.close();
		
		// Initialize a fraction calculator object and print the expression result
		FractionCalc fcal = new FractionCalc(input);
		Fraction result = fcal.evaluate();
		System.out.println("The result of the fraction expression is " + result);
	}
}
