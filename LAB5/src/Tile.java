import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{
	private static Polygon topLeft = new Polygon(new int[] {0, 0, 7, 7}, new int[] {14, 100, 93, 7}, 4);
	private static Polygon topRight = new Polygon(new int[] {7, 7, 14, 14}, new int[] {7, 93, 86, 0}, 4);
	private static Polygon bottomLower = new Polygon(new int[] {0, 7, 93, 86}, new int[] {100, 93, 93, 100}, 4);
	private static Polygon bottomUpper = new Polygon(new int[] {7, 14, 100, 93}, new int[] {93, 86, 86, 93}, 4);
	private static Rectangle face = new Rectangle(14, 0, 86, 86);
	
	private static GradientPaint grad;
	
	private static Color burlywood1 = new Color(255, 211, 155);
	private static Color antiquewhite1 = new Color(255, 239, 219);
	
	private static Color darkgoldenrod = new Color(238, 173, 14);
	private static Color goldenrod = new Color(255, 193, 37);
	
	private static Color sapgreen = new Color(48, 128, 20);
	private static Color palegreen = new Color(124, 205, 124);
	
	public Tile()
	{
		setPreferredSize(new Dimension(100, 100));
	
	}

	public boolean matches(Tile other)
	{
		if (this == other)
			return true;
		
		if (other == null)
			return false;
		
		return (this.getClass() == other.getClass()) ? true :  false;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		
		Graphics2D g2 = (Graphics2D)g;
		
		// Paint the face of the tile
		grad = new GradientPaint(14, 86, burlywood1, 100, 0, antiquewhite1);
		g2.setPaint(grad);
		g2.fill(face);
	
		// Paint the egdes of the tile
		grad = new GradientPaint(7, 7, sapgreen, 0, 100, palegreen);
		g2.setPaint(grad);
		g2.fill(topLeft);
		
		grad = new GradientPaint(93, 93, sapgreen, 0, 100, palegreen);
		g2.setPaint(grad);
		g2.fill(bottomLower);
		
		grad = new GradientPaint(100, 86, darkgoldenrod, 7, 93, goldenrod);
		g2.setPaint(grad);
		g2.fill(bottomUpper);
		
		grad = new GradientPaint(14, 0, darkgoldenrod, 7, 93, goldenrod);
		g2.setPaint(grad);
		g2.fill(topRight);
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		frame.setSize(new Dimension(700, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");
		frame.setLocation(500, 500);
		
		frame.add(new Tile());
		frame.pack();
		frame.setVisible(true);
	}
}
