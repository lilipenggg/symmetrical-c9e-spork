import java.util.*;

public class MahJongModel extends ArrayList<TileLayer>
{
	private RandomTileDeck deck;
	
	public MahJongModel(int seed)
	{
		deck = new RandomTileDeck(seed);
		
		// add all the tile models layers into the mahjong model
		this.add(new BottomLayer().createLayer(deck));
		this.add(new SquareLayer(6).createLayer(deck));
		this.add(new SquareLayer(4).createLayer(deck));
		this.add(new SquareLayer(2).createLayer(deck));
		this.add(new SquareLayer(1).createLayer(deck));
	}
	
	public boolean isTileOpen(TileModel t)
	{
		TileModel tile = null;
		// use isVisible for now to determine if it is visible
		
		// special case - check to see if this tile is any of the special tile's neighbour
		// 1.1 - top tile neighbor
		if (t.z == 3)
		{
			tile = getTile(6, 3, 4);
		}
		// 1.2 - bottom left tile neighbor
		else if (t.x == 1 && (t.y == 3 || t.y == 4) && t.z == 0)
		{
			tile = getTile(0,3,0);
		}
		// 1.3 - bottom right most tile neighbor
		else if (t.x == 13 && t.y == 3 && t.z == 0)
		{
			tile = getTile(14, 3, 0);
		}
		// 1.4 - bottom second to the right most tile neighbor
		else if (t.x == 12 && (t.y == 3 || t.y == 4) && t.z == 0)
		{
			tile = getTile(13, 3, 0);
		}
		// general case - tiles that are not neighbors with the four special tiles
		else 
		{
			TileModel right = getTile(t.x + 1, t.y, t.z);
			TileModel left = getTile(t.x - 1, t.y, t.z);
			TileModel top = getTile(t.x, t.y, t.z + 1);
			
			// the tile is not open when both of its left and right neighbor exists or the top neighbor exists
			if ((right != null && right.tile.visible && left != null && left.tile.visible) || (top != null && top.tile.visible))
			{
				return false;
			}
		}
		
		if (tile != null && tile.tile.visible)
		{
			return false;
		}
		
		// this tile is open when it passes all the special cases
		return true;
	}
	
	/*
	 * Pass in the x, y, z value to look for the TileModel that contains these three index values
	 * Return null if can't find the matching tile
	 */
	public TileModel getTile(int x, int y, int z)
	{
		for (int i = this.size() - 1; i >= 0; i--)
		{
			TileLayer layer = this.get(i);
			for (int j = layer.size() - 1; j >= 0; j--)
			{
				TileRow row = layer.get(j);
				for(int k = 0; k < row.size(); k++)
				{
					TileModel tile = row.get(k);
					if (tile.x == x && tile.y == y && tile.z == z)
						return tile;
				}
			}
		}
		return null;
	}

	public void addTile(int x, int y, int z)
	{
		getTile(x, y, z).tile.setVisible(true);
	}
	
	public void removeTile(int x, int y, int z)
	{
		getTile(x, y, z).tile.setVisible(false);
	}
}
