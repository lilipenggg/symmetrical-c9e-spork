import java.util.*;

public class RandomTileDeck 
{
	private ArrayList<TileModel> deck;
	
	public RandomTileDeck(int seed)
	{
		deck = new ArrayList<>();
		
		//Random rand = new Random(new Date().getTime());
		
		for (int i = 0; i < 4; i++)
		{
			// add all the character tiles
			deck.add(new TileModel(new CharacterTile('1')));
			deck.add(new TileModel(new CharacterTile('2')));
			deck.add(new TileModel(new CharacterTile('3')));
			deck.add(new TileModel(new CharacterTile('4')));
			deck.add(new TileModel(new CharacterTile('5')));
			deck.add(new TileModel(new CharacterTile('6')));
			deck.add(new TileModel(new CharacterTile('7')));
			deck.add(new TileModel(new CharacterTile('8')));
			deck.add(new TileModel(new CharacterTile('9')));
			
			deck.add(new TileModel(new CharacterTile('N')));
			deck.add(new TileModel(new CharacterTile('E')));
			deck.add(new TileModel(new CharacterTile('W')));
			deck.add(new TileModel(new CharacterTile('S')));
			deck.add(new TileModel(new CharacterTile('C')));
			deck.add(new TileModel(new CharacterTile('F')));
			deck.add(new TileModel(new WhiteDragonTile()));
			
			// add all the circle tiles
			deck.add(new TileModel(new CircleTile(1)));
			deck.add(new TileModel(new CircleTile(2)));
			deck.add(new TileModel(new CircleTile(3)));
			deck.add(new TileModel(new CircleTile(4)));
			deck.add(new TileModel(new CircleTile(5)));
			deck.add(new TileModel(new CircleTile(6)));
			deck.add(new TileModel(new CircleTile(7)));
			deck.add(new TileModel(new CircleTile(8)));
			deck.add(new TileModel(new CircleTile(9)));
			
			// add all the bamboo tiles
			deck.add(new TileModel(new Bamboo1Tile()));
			deck.add(new TileModel(new BambooTile(2)));
			deck.add(new TileModel(new BambooTile(3)));
			deck.add(new TileModel(new BambooTile(4)));
			deck.add(new TileModel(new BambooTile(5)));
			deck.add(new TileModel(new BambooTile(6)));
			deck.add(new TileModel(new BambooTile(7)));
			deck.add(new TileModel(new BambooTile(8)));
			deck.add(new TileModel(new BambooTile(9)));
		}
		
		// add all the flower tiles
		deck.add(new TileModel(new FlowerTile("Chrysanthemum")));
		deck.add(new TileModel(new FlowerTile("Orchid")));
		deck.add(new TileModel(new FlowerTile("Plum")));
		deck.add(new TileModel(new FlowerTile("Bamboo")));
		
		// add all the season tiles
		deck.add(new TileModel(new SeasonTile("Spring")));
		deck.add(new TileModel(new SeasonTile("Summer")));
		deck.add(new TileModel(new SeasonTile("Fall")));
		deck.add(new TileModel(new SeasonTile("Winter")));
		
		// shuffle the tiles
		Collections.shuffle(deck, new Random(seed));
	}
	
	public ArrayList<TileModel> getDeck()
	{
		return deck;
	}
	
	public TileModel deal()
	{
		return deck.remove(deck.size() - 1);
	}
}
