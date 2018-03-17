import javax.swing.*;
import java.awt.*;

public class WhiteDragonTile extends Tile
{
	public WhiteDragonTile()
	{
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		int buf = 8;
		int borderThickness = 7;
		int outerBorderWidth = size - buf * 2;
		int outerBorderHeight = size - buf * 2;
		int innerBorderWidth = size - buf * 2 - borderThickness * 2;
		int innerBorderHeight = size - buf * 2 - borderThickness * 2;
		
		int sRecWidth = 14;
		int sRecHeight = borderThickness;
		
		// Draw top border's blue and white rectangles
		g.setColor(royalblue);
		g.fillRect(faceX + buf, buf, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 2 * sRecWidth, buf, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 4 * sRecWidth, buf, sRecWidth, sRecHeight);
		
		g.setColor(Color.WHITE);
		g.fillRect(faceX + buf + sRecWidth, buf, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 3 * sRecWidth, buf, sRecWidth, sRecHeight);
		
		// Draw bottom border's blue and white rectangles
		g.setColor(royalblue);
		g.fillRect(faceX + buf, buf + borderThickness + innerBorderHeight, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 2 * sRecWidth, buf + borderThickness + innerBorderHeight, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 4 * sRecWidth, buf + borderThickness + innerBorderHeight, sRecWidth, sRecHeight);
		
		g.setColor(Color.WHITE);
		g.fillRect(faceX + buf + sRecWidth, buf + borderThickness + innerBorderHeight, sRecWidth, sRecHeight);
		g.fillRect(faceX + buf + 3 * sRecWidth, buf + borderThickness + innerBorderHeight, sRecWidth, sRecHeight);
			
		// Draw left side border's blue and white rectangles
		g.setColor(Color.WHITE);
		g.fillRect(faceX + buf, buf + borderThickness, sRecHeight, sRecWidth);
		g.fillRect(faceX + buf, buf + borderThickness + 2 * sRecWidth, sRecHeight, sRecWidth);
		g.setColor(royalblue);
		g.fillRect(faceX + buf, buf + borderThickness + sRecWidth, sRecHeight, sRecWidth);
		g.fillRect(faceX + buf, buf + borderThickness + 3 * sRecWidth, sRecHeight, sRecWidth);
		
		// Draw right side border's blue and white rectangles
		g.setColor(royalblue);
		g.fillRect(faceX + size - buf - borderThickness, buf + borderThickness, sRecHeight, sRecWidth);
		g.fillRect(faceX + size - buf - borderThickness, buf + borderThickness + 2 * sRecWidth, sRecHeight, sRecWidth);
		g.setColor(Color.WHITE);
		g.fillRect(faceX + size - buf - borderThickness, buf + borderThickness + sRecWidth, sRecHeight, sRecWidth);
		g.fillRect(faceX + size - buf - borderThickness, buf + borderThickness + 3 * sRecWidth, sRecHeight, sRecWidth);
		
		// Draw the border line
		g.setColor(Color.BLACK);
		g.drawRect(faceX + buf, buf, outerBorderWidth, outerBorderHeight);
		g.drawRect(faceX + buf + borderThickness, buf + borderThickness, innerBorderWidth, innerBorderHeight);
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}
