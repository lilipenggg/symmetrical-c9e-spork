import java.util.*;

public class SquareLayer extends TileLayer
{
	private int size;
	private int layerNum;
	
	public SquareLayer(int size)
	{
		this.size = size;
		
		if (size == 6)
		{
			layerNum = 1;
		}
		else if (size == 4)
		{
			layerNum = 2;
		}
		else if (size == 2)
		{
			layerNum = 3;
		}
		else if (size == 1)
		{
			layerNum = 4;
		}
	}
	
	@Override
	public TileLayer createLayer(RandomTileDeck deck)
	{
		for (int i = 0; i < size; i++)
		{
			this.add(new TileRow(deck, size));
		}
		updateCoordinates();
		return this;
	}
	
	private void updateCoordinates()
	{
		for (int i = 0; i < size; i++)
		{
			TileModel tile;
			TileRow row = this.get(i);
			
			for (int j = 0; j < row.size(); j++)
			{
				tile = row.get(j);
				
				/* handle layer 1 scenario */
				if (size == 6)
				{
					tile.updateCoordinates(j + 4, i + 1, layerNum);
				}
				/* handle layer 2 scenario */
				else if (size == 4)
				{
					tile.updateCoordinates(j + 5, i + 2, layerNum);
				}
				/* handle layer 3 scenario */
				else if (size == 2)
				{
					tile.updateCoordinates(j + 6, i + 3, layerNum);
				}
				/* handle layer 4 scenario */
				else if (size == 1)
				{
					tile.updateCoordinates(j + 6, i + 3, layerNum);
				}
			}
		}
	}
}
