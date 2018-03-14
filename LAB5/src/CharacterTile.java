import java.util.*;
import javax.swing.*;
import java.awt.*;

public class CharacterTile extends Tile
{
	protected char symbol;
	
	private static HashMap<Character, String> charHash;
	String wan = Character.toString('\u842C');
	
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
		
	}
	
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		// Retrieve the string that represents this symbol
		String symbolStr = charHash.get(symbol);
		
		// Draw the character on the tile based on the type of character tile
		switch (symbol) 
		{
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				drawTileChar(g, symbolStr, 2, 0, Color.BLACK, 32);
				drawTileChar(g, wan, 2, 1, Color.RED, 32);
				break;
			case 'N':
			case 'E':
			case 'W':
			case 'S':
				drawTileChar(g, symbolStr, 1, 0, Color.BLACK, 45);
				break;
			case 'C':
				drawTileChar(g, symbolStr, 1, 0, Color.RED, 45);
				break;
			case 'F':
				drawTileChar(g, symbolStr, 1, 0, forestgreen, 45);
				break;
			default:
				break;
		}
		
		drawIndicator(g);
		setToolTipText(this.toString());
	}
	
	private void drawTileChar(Graphics g, String symbolStr, int numOfChars, int pos, Color color, int fontSize)
	{
		g.setFont(new Font("Roman", Font.PLAIN, fontSize));
		g.setColor(color);
		
		int verLen = (super.getHeight() - 14) / numOfChars;
		
		int width = g.getFontMetrics().stringWidth(symbolStr);
		int height = g.getFontMetrics().getHeight();
		
		int x = (super.getWidth() + 14 - width) / 2;
		int y = g.getFontMetrics().getAscent() + (verLen - height) / 2 + pos * verLen;
		
		g.drawString(symbolStr, x, y);
	}
	
	private void drawIndicator(Graphics g)
	{
		g.setFont(new Font("Roman", Font.PLAIN, 12));
		g.setColor(Color.RED);
		g.drawString(String.valueOf(symbol), super.getWidth() - 15, 15);
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
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}
