import java.util.*;

public class MahJongModel extends ArrayList<TileLayer>
{
	private RandomTileDeck deck;
	
	public MahJongModel()
	{
		deck = new RandomTileDeck();
	}
	
	public void positionTile(TileModel tile, int x, int y, int z)
	{
		TileLayer tl = this.get(z);
		TileRow tr = tl.get(y);
		TileModel tm = tr.get(x);
		
		// general rule - layer z and row y is already initialized, tile is not there
		if (tl != null && tr != null && tm == null)
		{
			tr.add(x, tile);
		}
		
		if (tl == null)
			tl = new TileLayer();
	}
	
	public boolean isTileOpen(Tile t)
	{
		if (x == 0 || x == 14 || z == 4)
			return true;

		return tiles[z + 1] == null &&
			(tiles[x - 1, y, z] == null || tiles[x + 1, y, z] == null);
	}
	
	public Tile getTile(int x, int y, int z)
	{
		return this.get(z).get(y).get(x);
	}

}
