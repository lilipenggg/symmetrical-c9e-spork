import java.util.*;

public class BottomLayer extends TileLayer
{	
	@Override
	public TileLayer createLayer(RandomTileDeck deck)
	{
		this.add(new TileRow(deck, 12));
		this.add(new TileRow(deck, 8));
		this.add(new TileRow(deck, 10));
		this.add(new TileRow(deck, 14));
		this.add(new TileRow(deck, 12));
		this.add(new TileRow(deck, 10));
		this.add(new TileRow(deck, 8));
		this.add(new TileRow(deck, 12));
		
		// special case
		this.add(new TileRow(deck, 1));
		
		updateCoordinates();
		return this;
		// need to deal with the extra one on the left and extra two on the right of the bottom layer
	}
	
	private void updateCoordinates()
	{
		// loop through every row in the layer
		int layerNum = 0;
		for (int i = 0; i < this.size(); i++)
		{
			TileModel tile;
			TileRow row = this.get(i);
			
			/* handle the first and last row at the bottom layer */
			if (i == 0 || i == 7 || i == 3 || i == 4)
			{
				for (int j = 0; j < row.size(); j++)
				{
					tile = row.get(j);
					tile.updateCoordinates(j + 1, i, layerNum);
				}
			}
			/* handle the second and the second to last row at the bottom layer */
			else if (i == 1 || i == 6)
			{
				for (int j = 0; j < row.size(); j++)
				{
					tile = row.get(j);
					tile.updateCoordinates(j + 3, i, layerNum);
				}
			}
			/* handle the second and the second to last row at the bottom layer */
			else if (i == 2 || i == 5)
			{
				for (int j = 0; j < row.size(); j++)
				{
					tile = row.get(j);
					tile.updateCoordinates(j + 2, i, layerNum);
				}
			}
			
			/* handle the special tile */
			else if (i == 8)
			{
				tile = row.get(0);
				tile.updateCoordinates(0, 3, layerNum);
			}
		}
	}
}
