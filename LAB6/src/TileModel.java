
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

	public boolean isVisible() 
	{
		return tile.isVisible();
	}
	
	public void updateCoordinates(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
