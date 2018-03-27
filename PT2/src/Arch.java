import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Arch extends JFrame
{
	private ImageIcon image;
	private int borderSize;
	
	public Arch()
	{
		setTitle("Arch");
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		borderSize = 20;
		
		try
		{
			image = new ImageIcon(new URL("https://www.nps.gov/arch/planyourvisit/images/delicate3.jpg"));
		}
		catch (MalformedURLException murle)
		{
			JOptionPane.showMessageDialog(this, "Bad URL: " + murle, "Image Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		add(new Display());
		pack();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
		
		setVisible(true);
	}
	
	class Display extends JPanel
	{
		private int captionHeight = 25;
		
		public Display()
		{
			setPreferredSize(new Dimension(image.getIconWidth() + borderSize * 2, image.getIconHeight() + borderSize * 2 + captionHeight));
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, getWidth(), getHeight() - captionHeight);
			
			image.paintIcon(this, g, borderSize, borderSize);
			
			String caption = "Delicate Arch";
			Font f = g.getFont();
			f = f.deriveFont(f.getSize2D() * 1.2F);
			g.setFont(f);
			
			int wid = g.getFontMetrics().stringWidth(caption);
			g.setColor(Color.RED);
			g.drawString(caption, (getWidth() - wid) / 2, getHeight() - captionHeight / 3);
		}
	}
	
	public static void main(String[] args) 
	{
		new Arch();
	}
}
