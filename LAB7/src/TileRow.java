import java.util.*;

/* a single row of tiles */
public class TileRow extends ArrayList<TileModel>
{	
	public TileRow(RandomTileDeck deck, int count)
	{
		for (int i = 0; i < count; i++)
		{
			this.add(deck.deal());
		}
	}
}
