import java.util.*;

public class MahJongModel extends ArrayList<TileLayer>
{
	private RandomTileDeck deck;
	
	public MahJongModel()
	{
		deck = new RandomTileDeck();
		
		this.add(new BottomLayer().createLayer(deck));
		this.add(new SquareLayer(6).createLayer(deck));
		this.add(new SquareLayer(4).createLayer(deck));
		this.add(new SquareLayer(2).createLayer(deck));
		this.add(new SquareLayer(1).createLayer(deck));
		
		updateCoordinates();
	}
	
	public void updateCoordinates()
	{
		for (int i = 0; i < this.size(); i++)
		{
			TileLayer layer = this.get(i);
			for (int j = 0; j < layer.size(); j++)
			{
				TileRow row = layer.get(j);
				for (int k = 0; k < row.size(); k++)
				{
					TileModel tile = row.get(k);
					tile.updateCoordinates(k, j, i);
				}
			}
		}
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
