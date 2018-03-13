
abstract public class PictureTile extends Tile
{
	private String name;
	
	public PictureTile(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		switch(name)
		{
			case "Chrysanthemum":
				return "Chrysanthemum";
			case "Orchid":
				return "Orchid";
			case "Plum":
				return "Plum";
			case "Bamboo":
				return "Bamboo";
			case "Spring":
				return "Spring";
			case "Summer":
				return "Summer";
			case "Fall":
				return "Fall";
			case "Winter":
				return "Winter";
		}
		
		return "";
	}
}
