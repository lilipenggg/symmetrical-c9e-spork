import java.util.*;

/* a single row of tiles */
public class TileRow extends ArrayList<TileModel>
{
	private TileModel sTile;
	private TileModel eTile;
	
	public TileRow(ArrayList<TileModel> tiles)
	{
		for (TileModel t : this)
		{
			this.add(t);		
		}
	}
	
	public TileModel getFirstTile()
	{
		for (TileModel t : this)
		{
			if (t != null && t.isVisible()) 
			{
				sTile = t;
				return sTile;
			}
		}
		
		sTile = null;
		return sTile;
	}
	
	public TileModel getLastTile()
	{
		for (int i = 0; i < this.size(); i++)
		{
			if (i == this.size() - 1) 
			{
				TileModel t = this.get(i);
				if (t != null && !t.isVisible()) 
				{
					eTile = this.get(i);
					return eTile;
				}
			}
		}
		
		eTile = null;
		return eTile;
	}
	
}
