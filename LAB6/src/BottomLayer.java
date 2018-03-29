import java.util.*;

public class BottomLayer extends TileLayer
{	
//	public TileLayer createLayer(ArrayList<TileModel> tiles)
//	{
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(0, 12)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(12, 20)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(20, 30)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(30, 42)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(42, 54)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(54, 64)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(64, 72)));
//		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(72, 84)));
//		
//		return this;
//		// need to deal with the extra one on the left and extra two on the right of the bottom layer
//	}
	
	@Override
	public TileLayer createLayer(RandomTileDeck deck)
	{
		this.add(new TileRow(deck, 12));
		this.add(new TileRow(deck, 8));
		this.add(new TileRow(deck, 10));
		this.add(new TileRow(deck, 12));
		this.add(new TileRow(deck, 12));
		this.add(new TileRow(deck, 10));
		this.add(new TileRow(deck, 8));
		this.add(new TileRow(deck, 12));
		
		return this;
		// need to deal with the extra one on the left and extra two on the right of the bottom layer
	}
}
