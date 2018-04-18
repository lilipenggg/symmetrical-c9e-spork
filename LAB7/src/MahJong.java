import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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

		JMenuItem menuItemPlay = new JMenuItem("Play", 'P');
		gameMenu.add(menuItemPlay);
		menuItemPlay.addActionListener(new ActionListener() 
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
		
		JMenuItem menuItemRestart = new JMenuItem("Restart", 'R');
		gameMenu.add(menuItemRestart);
		menuItemRestart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.restart();
			}
		});
		
		JMenuItem menuItemNumbered = new JMenuItem("Numbered", 'N');
		gameMenu.add(menuItemNumbered);
		menuItemNumbered.addActionListener(new ActionListener() 
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
		
		JMenuItem menuItemOn = new JMenuItem("On", 'O');
		soundMenu.add(menuItemOn);
		menuItemOn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.setSound(true);
			}
		});
		
		JMenuItem menuItemOff = new JMenuItem("Off", 'f');
		soundMenu.add(menuItemOff);
		menuItemOff.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.setSound(false);
			}
		});
		
		JMenu moveMenu = new JMenu("Move");
		moveMenu.setMnemonic('M');
		menuBar.add(moveMenu);
		
		JMenuItem menuItemUndo = new JMenuItem("Undo", 'U');
		moveMenu.add(menuItemUndo);
		menuItemUndo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				board.undo();
			}
		});
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		
		JMenuItem menuItemOperation = new JMenuItem("Operation", 'O');
		helpMenu.add(menuItemOperation);
		menuItemOperation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Help("/help/operation.html", "Operation").display();
			}
		});
		
		JMenuItem menuItemGameRules = new JMenuItem("Game Rules", 'G');
		helpMenu.add(menuItemGameRules);
		menuItemGameRules.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Help("/help/game-rules.html", "Game Rules").display();
			}
		});
		return menuBar;
	}
}
