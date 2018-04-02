import javax.swing.*;
import java.awt.*;
import java.net.*;


abstract public class PictureTile extends Tile
{
	private String name;
	private ImageIcon image;
	
	public PictureTile(String name)
	{
		this.name = name;
		image = new ImageIcon(PictureTile.class.getResource("/resources/" + name + ".png"));
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		setToolTipText(toString());
		
		int imgSize = (int)(size * .9);
		g.drawImage(image.getImage(), faceX + size / 2 - imgSize / 2, size / 2 - imgSize / 2, imgSize, imgSize, this);	
	}
	
	public String toString()
	{
		switch(name)
		{
			case "Chrysanthemum":
				return "Chrysanthemum";
			case "Orchid":
				return "Orchid";
			case "Plum":
				return "Plum";
			case "Bamboo":
				return "Bamboo";
			case "Spring":
				return "Spring";
			case "Summer":
				return "Summer";
			case "Fall":
				return "Fall";
			case "Winter":
				return "Winter";
		}
		
		return "";
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
