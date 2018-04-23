import	java.util.*;
import	java.awt.*;
import	javax.swing.*;


public class ReviewPane extends JScrollPane
{
	private	JPanel[]	discard = new JPanel[2];
	private		int		width = Tile.size + Tile.faceX;
	private		int		height = Tile.size + Tile.faceX;
	private		int		count = 0;


	public ReviewPane(Stack<TilePair> removed)
	{
		setPreferredSize(new Dimension(0, 2 * height + 33));
		setBorder(BorderFactory.createRaisedBevelBorder());

		discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		discard[0].setPreferredSize(new Dimension(width, height));
		discard[1].setPreferredSize(new Dimension(width, height));

		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel	panel = new JPanel(new BorderLayout());
		setViewportView(panel);

		panel.add(discard[0], BorderLayout.NORTH);
		panel.add(discard[1], BorderLayout.SOUTH);

		discard[0].setBackground(new Color(254, 205, 33));
		discard[1].setBackground(new Color(254, 205, 33));
		panel.setBackground(new Color(254, 205, 33));
		
		for (int i = removed.size() - 1; i >= 0; i--)
		{
			TilePair pair = removed.get(i);
			addToUndo(pair.first.tile, pair.second.tile);
		}
	}


	public void addToUndo(Tile t1, Tile t2)
	{
		Dimension	size = new Dimension(++count * width, height + 6);
		discard[0].setPreferredSize(size);
		discard[1].setPreferredSize(size);
		
		addTile(t1, 0);
		addTile(t2, 1);
	}
	
	private void addTile(Tile t, int pos)
	{
		String tileType = t.toString();
		switch(tileType)
		{
			case "Character 1":
				discard[pos].add(new CharacterTile('1'));
				break;
			case "Character 2":
				discard[pos].add(new CharacterTile('2'));
				break;
			case "Character 3":
				discard[pos].add(new CharacterTile('3'));
				break;
			case "Character 4":
				discard[pos].add(new CharacterTile('4'));
				break;
			case "Character 5":
				discard[pos].add(new CharacterTile('5'));
				break;
			case "Character 6":
				discard[pos].add(new CharacterTile('6'));
				break;
			case "Character 7":
				discard[pos].add(new CharacterTile('7'));
				break;
			case "Character 8":
				discard[pos].add(new CharacterTile('8'));
				break;
			case "Character 9":
				discard[pos].add(new CharacterTile('9'));
				break;
			case "North Wind":
				discard[pos].add(new CharacterTile('N'));
				break;
			case "South Wind":
				discard[pos].add(new CharacterTile('S'));
				break;
			case "East Wind":
				discard[pos].add(new CharacterTile('E'));
				break;
			case "West Wind":
				discard[pos].add(new CharacterTile('W'));
				break;
			case "Red Dragon":
				discard[pos].add(new CharacterTile('C'));
				break;
			case "Green Dragon":
				discard[pos].add(new CharacterTile('F'));
				break;
			case "Chrysanthemum":
				discard[pos].add(new FlowerTile("Chrysanthemum"));
				break;
			case "Orchid":
				discard[pos].add(new FlowerTile("Orchid"));
				break;
			case "Plum":
				discard[pos].add(new FlowerTile("Plum"));
				break;
			case "Bamboo":
				discard[pos].add(new FlowerTile("Bamboo"));
				break;
			case "Spring":
				discard[pos].add(new FlowerTile("Spring"));
				break;
			case "Summer":
				discard[pos].add(new FlowerTile("Summer"));
				break;
			case "Fall":
				discard[pos].add(new FlowerTile("Fall"));
				break;
			case "Winter":
				discard[pos].add(new FlowerTile("Winter"));
				break;
			case "Bamboo 1":
				discard[pos].add(new Bamboo1Tile());
				break;
			case "Bamboo 2":
				discard[pos].add(new BambooTile(2));
				break;
			case "Bamboo 3":
				discard[pos].add(new BambooTile(3));
				break;
			case "Bamboo 4":
				discard[pos].add(new BambooTile(4));
				break;
			case "Bamboo 5":
				discard[pos].add(new BambooTile(5));
				break;
			case "Bamboo 6":
				discard[pos].add(new BambooTile(6));
				break;
			case "Bamboo 7":
				discard[pos].add(new BambooTile(7));
				break;
			case "Bamboo 8":
				discard[pos].add(new BambooTile(8));
				break;
			case "Bamboo 9":
				discard[pos].add(new BambooTile(9));
				break;
			case "Circle 1":
				discard[pos].add(new CircleTile(1));
				break;
			case "Circle 2":
				discard[pos].add(new CircleTile(2));
				break;
			case "Circle 3":
				discard[pos].add(new CircleTile(3));
				break;
			case "Circle 4":
				discard[pos].add(new CircleTile(4));
				break;
			case "Circle 5":
				discard[pos].add(new CircleTile(5));
				break;
			case "Circle 6":
				discard[pos].add(new CircleTile(6));
				break;
			case "Circle 7":
				discard[pos].add(new CircleTile(7));
				break;
			case "Circle 8":
				discard[pos].add(new CircleTile(8));
				break;
			case "Circle 9":
				discard[pos].add(new CircleTile(9));
				break;
			case "White Dragon":
				discard[pos].add(new WhiteDragonTile());
			default:
				break;
		}
	}
}
