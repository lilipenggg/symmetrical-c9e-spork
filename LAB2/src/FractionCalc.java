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
		StringTokenizer parser = new StringTokenizer(input, " \t/+-*", true);
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
			String token = parser.nextToken();
			if (token != "\t" && token != " ")
				arr.add(token);
		}
	
		// Parse the expression and extract operator and operands
		ArrayList<Integer> exp = new ArrayList<Integer>();
		boolean negative = false;
		boolean hasOperator = false;
		for (int i = 0; i < arr.size(); i++)
		{
			String pos = arr.get(i);
			
			// Check if this is the operator in the expression
			if (isOperator(pos) && exp.size() == 2 && !hasOperator)
			{
				this.operator = pos.charAt(0);
				hasOperator = true;
				continue;
			}
			
			if (pos.equals("-"))
			{
				negative = true;
				continue;
			}
			else if (isNumber(pos))
			{
				if (negative == true)
				{
					exp.add(Integer.parseInt("-" + pos));
					negative = false;
				}
				else
				{
					exp.add(Integer.parseInt(pos));
				}
			}
			else if (pos.equals("/"))
				continue;
		}
		
		// Assign the left and right attributes with the parsing result
		this.left = new Fraction(exp.get(0), exp.get(1));
		this.right = new Fraction(exp.get(2), exp.get(3));
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
	
	/*
	 * This helper method checks whether the string is a number, return true if so, otherwise false
	 */
	private boolean isNumber(String s)
	{
		try 
		{
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	/*
	 * This helper method checks whether a string is a operator, return true if so, otherwise false
	 */
	private boolean isOperator(String s)
	{
		boolean result = false;
		
		switch (s)
		{
			case "+":
				result = true;
				break;
			case "-":
				result = true;
				break;
			case "*":
				result = true;
				break;
			case "/":
				result = true;
				break;
			default:
				result = false;
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
		scanner.close();
		
		// Initialize a fraction calculator object and print the expression result
		FractionCalc fcal = new FractionCalc(input);
		Fraction result = fcal.evaluate();
		System.out.println("The result of the fraction expression is " + result);
		
		System.exit(0);
	}
}
