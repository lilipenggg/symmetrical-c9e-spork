
public class BambooTile extends RankTile
{
	public BambooTile(int rank)
	{
		super(rank);
	}
	
	public String toString()
	{
		switch(rank)
		{
			case 2:
				return "Bamboo 2";
			case 3:
				return "Bamboo 3";
			case 4:
				return "Bamboo 4";
			case 5:
				return "Bamboo 5";
			case 6:
				return "Bamboo 6";
			case 7:
				return "Bamboo 7";
			case 8:
				return "Bamboo 8";
			case 9:
				return "Bamboo 9";
		}
		return "";
	}
}
