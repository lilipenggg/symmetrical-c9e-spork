import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MahJong extends JFrame
{
	private MahJongBoard board;
	
	public MahJong()
	{
		board = new MahJongBoard();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(board);
		
		setSize(new Dimension(1920, 1080));
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new MahJong();
	}
}
