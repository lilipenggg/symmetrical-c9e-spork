import java.awt.*;
import javax.swing.*;

public class MahjongTest extends JFrame
{
	public MahjongTest()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new TestPanel());
		
		setSize(500, 500);
		setVisible(true);
	}
	
	class TestPanel extends JPanel
	{
		public TestPanel()
		{
			setLayout(null);		// implies the Tile must setSize -- when Tile is in a container that does not have layout manager
			
			Tile t;
			t = new SeasonTile("Spring");
			t.setLocation(200, 100);
			add(t);
			
			t = new SeasonTile("Summer");
			t.setLocation(186, 114);	
			add(t);
			
			t = new SeasonTile("Fall");
			t.setLocation(172, 128);	
			add(t);
			
			t = new SeasonTile("Fall");
			t.setLocation(158, 142);	
			add(t);
		}
	}
	
	public static void main(String[] args)
	{
		new MahjongTest();
	}

}
