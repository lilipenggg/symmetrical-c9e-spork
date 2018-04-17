import java.util.*;

public class MahJongModel extends ArrayList<TileLayer>
{
	private RandomTileDeck deck;
	
	public MahJongModel()
	{
		deck = new RandomTileDeck();
		
		// add all the tile models layers into the mahjong model
		this.add(new BottomLayer().createLayer(deck));
		this.add(new SquareLayer(6).createLayer(deck));
		this.add(new SquareLayer(4).createLayer(deck));
		this.add(new SquareLayer(2).createLayer(deck));
		this.add(new SquareLayer(1).createLayer(deck));
	}
	
	public boolean isTileOpen(TileModel t)
	{
		// check to see if this tile is one of the special tiles
		if (t.x == 6 && t.y == 3 && t.z == 4 && t.tile.isVisible())
			return true;
		else if (t.x == 0 && t.y == 3 && t.z == 0 && t.tile.isVisible())
			return true;
		else if ((t.x == 12 || t.x == 13)&& t.y == 3 && t.z == 0 && t.tile.isVisible())
			return true;
		else if (this.getTileRow(t.z, t.y).getFirstTile().equals(t) || this.getTileRow(t.z, t.y).getLastTile().equals(t))
		{
			TileModel top = getTile(t.x, t.y, t.z + 1);
			if (top == null)
			{
				return true;
			}
			else if (top != null && !top.tile.isVisible())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}
	
	public TileRow getTileRow(int z, int y)
	{
		try
		{
			for (TileRow row : this.get(z))
			{
				if (row.get(0).y == y)
				{
					return row;
				}
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			return null;
		}
		return null;
	}
	
	public TileModel getTile(int x, int y, int z)
	{
		try
		{
			TileRow row = getTileRow(z, y);
			if (row != null)
			{
				for (TileModel tile : row)
				{
					if (tile.x == x)
					{
						return tile;
					}
				}
			}
			return null;
		}
		catch (IndexOutOfBoundsException e)
		{
			return null;
		}
	}

}
