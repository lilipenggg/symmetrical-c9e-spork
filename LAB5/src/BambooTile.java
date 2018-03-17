import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BambooTile extends RankTile
{
	private ArrayList<Bamboo> bamboos;
	
	private static int BAMBOO_HEIGHT = size / 5;
	private static int BAMBOO_WIDTH = size / 7;
	
	public BambooTile(int rank)
	{
		super(rank);
		bamboos = new ArrayList<>();
		
		switch(rank)
		{
			case 2:
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 2 - BAMBOO_HEIGHT - 2, royalblue));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, size / 2 + 2, limegreen));
				break;
			case 3:
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 2 - BAMBOO_HEIGHT - 2, royalblue));
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 + 2, limegreen));
				bamboos.add(new Bamboo(faceX + (4 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 + 2, limegreen));
				break;
			case 4:
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, royalblue));
				bamboos.add(new Bamboo(faceX + (4 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 + 2, limegreen));
				bamboos.add(new Bamboo(faceX + (4 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 + 2, royalblue));
				break;
			case 5:
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, royalblue));
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 + 2, royalblue));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 + 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 2 - BAMBOO_HEIGHT / 2, crimson));
				break;
			case 6:
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 + 2, royalblue));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 + 2, royalblue));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 2 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, size / 2 + 2, royalblue));
				break;
			case 7:
				// Left
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, limegreen));
				
				// Right
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, limegreen));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				
				// Middle
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, 2 * size / 3 - BAMBOO_HEIGHT - 2, royalblue));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, 2 * size / 3 + 2, royalblue));
				
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, size / 3 - BAMBOO_HEIGHT, crimson));
				break;
			case 8:
				// Top
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				// Bottom
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, royalblue));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, royalblue));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, 2 * size / 3 + 2, royalblue));
				// Middle
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT / 2, crimson));
				bamboos.add(new Bamboo(faceX + (4 * (size / 2) / 3) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT / 2, crimson));
				break;
			case 9:
				// Top
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 3 - BAMBOO_HEIGHT - 2, crimson));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 3 - BAMBOO_HEIGHT - 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH )/ 2, size / 3 - BAMBOO_HEIGHT - 2, royalblue));
				// Bottom
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, crimson));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, 2 * size / 3 + 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, 2 * size / 3 + 2, royalblue));
				// Middle
				bamboos.add(new Bamboo(faceX + (2 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT / 2, crimson));
				bamboos.add(new Bamboo(faceX + (6 * (size / 2) / 4) - BAMBOO_WIDTH / 2, size / 2 - BAMBOO_HEIGHT / 2, limegreen));
				bamboos.add(new Bamboo(faceX + (size - BAMBOO_WIDTH) / 2, size / 2 - BAMBOO_HEIGHT / 2, royalblue));
				break;
		}
	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Bamboo b : bamboos)
        {
            b.draw(g);
        }
    }

	
	class Bamboo 
	{
		private int height;
		private int width;
		private Color color;
		private int x;
		private int y;
		
		public Bamboo(int x, int y, Color color)
		{
			height = size / 5;
			width = size / 7;
			this.color = color;
			this.x = x;
			this.y = y;
		}
		
		public void draw(Graphics g)
		{
			int arc = 5;
			g.setColor(color);
			g.fillRect(x + width * 3 / 8, y, width * 5 / 12, height);
			
			g.fillRoundRect(x, y, width, height / 5, arc, arc);
			g.fillRoundRect(x, y + height, width, height / 5, arc, arc);
			
			// Draw the bamboo highlight
			Color prev = g.getColor();
			g.setColor(Color.WHITE);
			g.drawLine(x + width / 2 + 1, y + 3, x + width / 2 + 1, y + height - 1);
			
			g.setColor(prev);
			g.fillRoundRect(x, y + height / 2, width, height / 5, arc, arc);
		}
	}
	
	public String toString()
	{
		switch(rank)
		{
			case 2:
				return "Bamboo 2";
			case 3:
				return "Bamboo 3";
			case 4:
				return "Bamboo 4";
			case 5:
				return "Bamboo 5";
			case 6:
				return "Bamboo 6";
			case 7:
				return "Bamboo 7";
			case 8:
				return "Bamboo 8";
			case 9:
				return "Bamboo 9";
		}
		return "";
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
