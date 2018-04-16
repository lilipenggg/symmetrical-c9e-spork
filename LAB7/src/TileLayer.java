import java.util.*;

/*	a layer of tiles - composed of multiple rows of tiles */
public abstract class TileLayer extends ArrayList<TileRow>
{	
	public abstract TileLayer createLayer(RandomTileDeck deck);
}
