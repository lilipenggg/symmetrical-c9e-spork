import java.util.*;
import javax.swing.*;
import java.awt.*;

public class CharacterTile extends Tile
{
	protected char symbol;
	
	private static HashMap<Character, String> charHash;
	
	static 
	{
		charHash = new HashMap<Character, String>();
		charHash.put('1', Character.toString('\u4E00'));
		charHash.put('2', Character.toString('\u4E8C'));
		charHash.put('3', Character.toString('\u4E09'));
		charHash.put('4', Character.toString('\u56DB'));
		charHash.put('5', Character.toString('\u4E94'));
		charHash.put('6', Character.toString('\u516D'));
		charHash.put('7', Character.toString('\u4E03'));
		charHash.put('8', Character.toString('\u516B'));
		charHash.put('9', Character.toString('\u4E5D'));
		
		charHash.put('N', Character.toString('\u5317'));
		charHash.put('E', Character.toString('\u6771'));
		charHash.put('W', Character.toString('\u897F'));
		charHash.put('S', Character.toString('\u5357'));
		
		charHash.put('C', Character.toString('\u4E2D'));
		charHash.put('F', Character.toString('\u767C'));
		
		charHash.put('W', Character.toString('\u842C'));
	}
	
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	}
	
	public boolean matches(Tile other)
	{
		return (super.matches(other) && ((CharacterTile)other).symbol == this.symbol) ? true : false;
	}
	
	public String toString()
	{
		switch (symbol)
		{
			case '1':
				return "Character 1";
			case '2':
				return "Character 2";
			case '3':
				return "Character 3";
			case '4':
				return "Character 4";
			case '5':
				return "Character 5";
			case '6':
				return "Character 6";
			case '7':
				return "Character 7";
			case '8':
				return "Character 8";
			case '9':
				return "Character 9";
			case 'N':
				return "North Wind";
			case 'E':
				return "East Wind";
			case 'W':
				return "West Wind";
			case 'S':
				return "South Wind";
			case 'C':
				return "Red Dragon";
			case 'F':
				return "Green Dragon";
		}
		
		return "";
	}
}
