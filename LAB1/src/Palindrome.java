import java.util.Scanner;

public class Palindrome 
{
	public static void main(String[] args) 
	{
		String input = "";
		
		// Check whether the program is executed with arguments attached
		if (args.length != 0)
		{
			// Concatenate all the arguments from command line into a string
			StringBuilder builder = new StringBuilder();
			for (String s: args)
				builder.append(s);
			input = builder.toString();
		}
		// Prompt the user for input when there is no arguments attached
		else
		{
			// Read the user input from scanner
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter a string for testing: ");
			input = scan.nextLine();
			scan.close();
			
			// Make sure the input string is not empty so that empty string is not considered as palindrome
			if (input.length() == 0)
			{
				System.err.println("Error: the input string is empty.");
				System.exit(1);
			}
			
			// Remove all the spaces in the user's input
			input = input.replaceAll("\\s+", "");
		}
		
		// Check whether the input string is a palindrome
		String reverseString = new StringBuilder(input).reverse().toString();
		System.out.println((reverseString.equals(input)) ? "This is a palindrome" : "This is not a palindrome.");
	}

}
