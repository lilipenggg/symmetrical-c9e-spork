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
//		this.add(new SquareLayer(1).createLayer(deck));
		
	}
	
	public boolean isTileOpen(TileModel t)
	{
		if (t.x == 0 || t.x == 14 || t.z == 4)
			return true;

		return this.get(t.z + 1) == null &&
			(this.get(t.z).get(t.y).get(t.x - 1) == null || this.get(t.z).get(t.y).get(t.x + 1) == null);
	}
	
	public TileModel getTile(int x, int y, int z)
	{
		return this.get(z).get(y).get(x);
	}

}
