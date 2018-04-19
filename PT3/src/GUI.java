import javax.swing.*;
import java.awt.event.*;
import java.beans.EventHandler;
import java.awt.*;

public class GUI extends JFrame
{
	public GUI()
	{
		setTitle("GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 180);
		
		makeMenu();
		makeButtons();
		setVisible(true);
	}
	
	public void north()
	{
		JOptionPane.showMessageDialog(this, "North", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void south()
	{
		JOptionPane.showMessageDialog(this, "South", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void west()
	{
		JOptionPane.showMessageDialog(this, "West", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void east()
	{
		JOptionPane.showMessageDialog(this, "East", "Direction", JOptionPane.INFORMATION_MESSAGE);
	}
	
	Action northAction = new AbstractAction("North") 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			north();				
		}
	};
	
	Action southAction = new AbstractAction("South") 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			south();				
		}
	};
	
	Action westAction = new AbstractAction("West") 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			west();				
		}
	};
	
	Action eastAction = new AbstractAction("East") 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			east();				
		}
	};
	
	private void makeButtons()
	{
		JButton northButton = new JButton("North");
		JButton southButton = new JButton("South");
		JButton westButton = new JButton("West");
		JButton eastButton = new JButton("East");
		
		northButton.addActionListener(northAction);
		southButton.addActionListener(southAction);
		westButton.addActionListener(westAction);
		eastButton.addActionListener(eastAction);
		
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		
		northPanel.add(northButton);
		southPanel.add(southButton);
		westPanel.add(westButton);
		eastPanel.add(eastButton);
	}
	
	private void makeMenu()
	{
		JMenuBar	menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu directionMenu = makeMenu("Direction", 'D');
		menuBar.add(directionMenu);
		
		directionMenu.add(makeMenuItem("North", "North Direction", "ctrl N", 'N', "north", this));
		directionMenu.add(makeMenuItem("South", "South Direction", "ctrl S", 'S', "south", this));
		directionMenu.add(makeMenuItem("West", "West Direction", "ctrl W", 'W', "west", this));
		directionMenu.add(makeMenuItem("East", "East Direction", "ctrl E", 'E', "east", this));
	}
	
	private JMenuItem makeMenuItem(String label, String tip, String accelerator, char mnemonic,
			String method, Object target)
	{
		JMenuItem	menuItem = new JMenuItem(label, mnemonic);
		menuItem.setToolTipText(tip);				// adds tool tip text
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));

		// sets up event handling: "method" is called when "menuItem" is selected
		menuItem.addActionListener((ActionListener)EventHandler.create(ActionListener.class,
					target, method));

		return menuItem;
	}
	
	private JMenu makeMenu(String label, char mnemonic)
	{
		JMenu	menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}
	
	public static void main(String[] args)
	{
		new GUI();
	}
}
