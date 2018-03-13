
public class CharacterTile extends Tile
{
	protected char symbol;
	
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
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
