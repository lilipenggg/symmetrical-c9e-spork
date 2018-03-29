import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{
	private int x;
	private int y;
	private int z;
	
	private static Polygon topLeft;
	private static Polygon topRight;
	private static Polygon bottomLower;
	private static Polygon bottomUpper;
	protected static Rectangle face;
	
	protected static int faceX;
	protected static int faceY;
	protected static int size;
	
	private static GradientPaint gradFace;
	private static GradientPaint gradTopLeft;
	private static GradientPaint gradTopRight;
	private static GradientPaint gradBottomUpper;
	private static GradientPaint gradBottomLower;
	
	private static Color bisque;
	private static Color floralwhite;
	
	private static Color darkgoldenrod;
	private static Color goldenrod;
	
	private static Color sapgreen;
	private static Color palegreen;
	protected static Color forestgreen;
	
	protected static Color crimson;
	protected static Color limegreen;
	protected static Color royalblue;
	
	static 
	{
		faceX = 14;
		faceY = 14;
		size = 86;
				
		topLeft = new Polygon(new int[] {0, 0, 7, 7}, new int[] {14, 100, 93, 7}, 4);
		topRight = new Polygon(new int[] {7, 7, 14, 14}, new int[] {7, 93, 86, 0}, 4);
		bottomLower = new Polygon(new int[] {0, 7, 93, 86}, new int[] {100, 93, 93, 100}, 4);
		bottomUpper = new Polygon(new int[] {7, 14, 100, 93}, new int[] {93, 86, 86, 93}, 4);
		face = new Rectangle(14, 0, 86, 86);
		
		bisque = new Color(255, 228, 196);
		floralwhite = new Color(255, 250, 240);
		
		darkgoldenrod = new Color(238, 173, 14);
		goldenrod = new Color(255, 193, 37);
		
		sapgreen = new Color(48, 128, 20);
		palegreen = new Color(124, 205, 124);
		forestgreen = new Color(34, 139, 34);
		
		crimson = new Color(220, 20, 60);
		limegreen = new Color(50, 205, 50);
		royalblue = new Color(58, 95, 205);
		
		gradFace = new GradientPaint(14, 86, bisque, 100, 0, floralwhite);
		gradTopLeft = new GradientPaint(7, 7, sapgreen, 0, 100, palegreen);
		gradTopRight = new GradientPaint(14, 0, darkgoldenrod, 7, 93, goldenrod);
		gradBottomUpper = new GradientPaint(100, 86, darkgoldenrod, 7, 93, goldenrod);
		gradBottomLower = new GradientPaint(93, 93, sapgreen, 0, 100, palegreen);
	}
	
	public Tile()
	{
		//setPreferredSize(new Dimension(100, 100));
		setSize(new Dimension(100, 100));
		setOpaque(false);	
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
		g2.setPaint(gradFace);
		g2.fill(face);
	
		// Paint the egdes of the tile
		g2.setPaint(gradTopLeft);
		g2.fill(topLeft);
		
		g2.setPaint(gradBottomLower);
		g2.fill(bottomLower);
		
		g2.setPaint(gradBottomUpper);
		g2.fill(bottomUpper);
		
		g2.setPaint(gradTopRight);
		g2.fill(topRight);
		
		// Draw the edges for polygons and rectangles
		g.setColor(Color.DARK_GRAY);
		g.drawRect(14, 0, face.width, face.height);
		g.drawPolygon(topRight);
		g.drawPolygon(topLeft);
		g.drawPolygon(bottomUpper);
		g.drawPolygon(bottomLower);
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
