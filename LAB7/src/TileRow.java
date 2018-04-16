import java.util.*;

/* a single row of tiles */
public class TileRow extends ArrayList<TileModel>
{	
	public TileRow(RandomTileDeck deck, int count)
	{
		for (int i = 0; i < count; i++)
		{
			this.add(deck.deal());
		}
	}
	
	public TileModel getFirstTile()
	{
		for (TileModel t : this)
		{
			if (t != null && t.tile.isVisible()) 
			{
				return t;
			}
		}
		return null;
	}
	
	public TileModel getLastTile()
	{
		for (int i = this.size() - 1; i >= 0; i--)
		{
			TileModel t = this.get(i);
			if (t != null && t.tile.isVisible()) 
			{
				return t;
			}
		}
		return null;
	}
	
}
