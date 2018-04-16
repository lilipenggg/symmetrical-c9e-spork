
public class TileModel
{
	protected int x;
	protected int y;
	protected int z;
	protected Tile tile;
	
	public TileModel(Tile tile)
	{
		this.tile = tile;
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public TileModel(Tile tile, int x, int y, int z)
	{
		this.tile = tile;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void updateCoordinates(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean equals(Object obj)
	{
		TileModel t = (TileModel)obj;
		return t.x == this.x && t.y == this.y && t.z == this.z;
	}
}
