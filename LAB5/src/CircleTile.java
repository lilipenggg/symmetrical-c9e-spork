
public class CircleTile extends RankTile
{
	public CircleTile(int rank)
	{
		super(rank);
	}
	
	public String toString()
	{
		switch(rank)
		{
			case 1:
				return "Circle 1";
			case 2:
				return "Circle 2";
			case 3:
				return "Circle 3";
			case 4:
				return "Circle 4";
			case 5:
				return "Circle 5";
			case 6:
				return "Circle 6";
			case 7:
				return "Circle 7";
			case 8:
				return "Circle 8";
			case 9:
				return "Circle 9";
		}
		
		return "";
	}
}
