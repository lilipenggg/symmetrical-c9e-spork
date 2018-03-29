import java.util.*;

public class SquareLayer extends TileLayer
{
	private int size;
	
	public SquareLayer(int size)
	{
		this.size = size;
	}
	
//	@Override
//	public TileLayer createLayer(ArrayList<TileModel> tiles)
//	{
//		for (int i = 0; i < size; i++)
//		{
//			this.add(new TileRow((ArrayList<TileModel>)tiles.subList(i, i + size)));
//		}
//		
//		return this;
//	}
	
	@Override
	public TileLayer createLayer(RandomTileDeck deck)
	{
		for (int i = 0; i < size; i++)
		{
			this.add(new TileRow(deck, size));
		}
		return this;
	}
}