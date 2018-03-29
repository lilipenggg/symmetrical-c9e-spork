import java.util.*;

public class BottomLayer extends TileLayer
{	
	@Override
	public void createLayer(ArrayList<TileModel> tiles)
	{
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(0, 12)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(12, 20)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(20, 30)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(30, 42)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(42, 54)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(54, 64)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(30, 42)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(42, 50)));
		this.add(new TileRow((ArrayList<TileModel>)tiles.subList(50, 62)));
		
		// need to deal with the extra one on the left and extra two on the right of the bottom layer
	}
}
