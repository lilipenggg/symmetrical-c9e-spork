import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class MahJong extends JFrame
{
	private MahJongBoard board;
	private static MahJong game;
	
	// time seed used for restarting the game
	private int seed;
	
	private boolean playAudio;
	
	public MahJong()
	{
		seed = (int)(System.currentTimeMillis() % 1000000);
		board = new MahJongBoard(seed);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(board);
		setJMenuBar(this.makeMenu());
		setSize(new Dimension(1920, 1080));
		setTitle("MahJong Game: " +  String.valueOf(seed));
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		game = new MahJong();
	}
	
	private JMenuBar makeMenu() 
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('G');
		menuBar.add(gameMenu);

		JMenuItem playMenuItem = new JMenuItem("Play", 'P');
		gameMenu.add(playMenuItem);
		playMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int option;
				if (board.isStarted()) 
				{
					option = JOptionPane.showConfirmDialog(game, 
							"All your game progress will be lost, are you sure to start over?", 
							"New Game", JOptionPane.YES_NO_OPTION);
				}
				else
				{
					option = JOptionPane.showConfirmDialog(game, 
							"Ready to play a new game?", 
							"New Game", JOptionPane.YES_NO_OPTION);
				}
				
				if (option == JOptionPane.YES_OPTION)
				{
					//game.getContentPane().removeAll();
					game.remove(board);
					board = null;
					seed = (int)(System.currentTimeMillis() % 1000000);
					board = new MahJongBoard(seed);
					game.add(board);
					setTitle("MahJong Game: " +  String.valueOf(seed));
					
					revalidate();
					repaint();
				}
			}
		});
		
		JMenuItem restartMenuItem = new JMenuItem("Restart", 'R');
		gameMenu.add(restartMenuItem);
		restartMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// prompt the user for reconfirmation that they want to restart the game
				int option = JOptionPane.showConfirmDialog(game, "Are you sure you want to start over?", "Start Over", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
				{
					game.remove(board);
					board = null;
					board = new MahJongBoard(seed);
					game.add(board);
					setTitle("MahJong Game: " +  String.valueOf(seed));
					
					revalidate();
					repaint();
				}
			}
		});
		
		JMenuItem numberedMenuItem = new JMenuItem("Numbered", 'N');
		gameMenu.add(numberedMenuItem);
		numberedMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String gameNum = JOptionPane.showInputDialog(game, "Please enter the number of the game that you like to play:", "Game Number", JOptionPane.PLAIN_MESSAGE);
				if (gameNum == null)
				{
					return;
				}
				int seed = Integer.parseInt(gameNum);
				game.remove(board);
				board = new MahJongBoard(seed);
				game.add(board);
				setTitle("MahJong Game: " +  String.valueOf(seed));
				revalidate();
				repaint();
			}
		});
		
		JMenu soundMenu = new JMenu("Sound");
		soundMenu.setMnemonic('S');
		menuBar.add(soundMenu);
		
		JMenuItem onMenuItem = new JMenuItem("On", 'O');
		soundMenu.add(onMenuItem);
		onMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.setSound(true);
			}
		});
		
		JMenuItem offMenuItem = new JMenuItem("Off", 'f');
		soundMenu.add(offMenuItem);
		offMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.setSound(false);
			}
		});
		
		JMenu moveMenu = new JMenu("Move");
		moveMenu.setMnemonic('M');
		menuBar.add(moveMenu);
		
		JMenuItem undoMenuItem = new JMenuItem("Undo", 'U');
		moveMenu.add(undoMenuItem);
		undoMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.undo();
			}
		});
		
		JMenu viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');
		menuBar.add(viewMenu);
		
		JMenuItem removedMenuItem = new JMenuItem("Removed", 'R');
		viewMenu.add(removedMenuItem);
		removedMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
//				ReviewPane review  = new ReviewPane(board.getRemoved());
//				board.displayRemoved(review);
				displayRemoved();
			}
		});
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		
		JMenuItem operationMenuItem = new JMenuItem("Operation", 'O');
		helpMenu.add(operationMenuItem);
		operationMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Help("/help/operation.html", "Operation").display();
			}
		});
		
		JMenuItem gameRulesMenuItem = new JMenuItem("Game Rules", 'G');
		helpMenu.add(gameRulesMenuItem);
		gameRulesMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Help("/help/gamerules.html", "Game Rules").display();
			}
		});
		return menuBar;
	}
	
	private void displayRemoved()
	{
		/*GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);*/
		
		ReviewPane review  = new ReviewPane(board.getRemoved());
		
		JFrame reviewFrame = new JFrame();
		reviewFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		reviewFrame.add(review);
		reviewFrame.setSize(400, 250);
		reviewFrame.setVisible(true);
	}
}
