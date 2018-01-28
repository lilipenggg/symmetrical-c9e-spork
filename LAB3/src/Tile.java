
abstract public class Tile 
{
	public boolean matches(Tile other)
	{
		if (this == other)
			return true;
		
		if (other == null)
			return false;
		
		return (this.getClass() == other.getClass()) ? true :  false;
	}
}
