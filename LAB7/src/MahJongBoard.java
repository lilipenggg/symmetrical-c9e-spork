import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import javax.swing.border.*;

public class MahJongBoard extends JPanel implements MouseListener
{
	private MahJongModel model;
	private ImageIcon backgroundImg;
	private Color yellow;
	
	private int TILE_WIDTH = 86;
	private int TILE_HEIGHT = 86;
	private int TILE_EDGE = 14;
	
	// data members used for tracking which two tiles are selected
	private TileModel first = null;
	private TileModel second = null;
	
	// stack that holds the tile pairs that are removed
	private Stack<TilePair> removed;
	
	// data member used to store the zorder of the special case tiles at the bottom layer
	private ArrayList<Integer> bottomLayerZOrder;
	
	// border that highlights the selected tile
	private Border selected = BorderFactory.createLineBorder(Color.RED, 2);
	
	private Fireworks fireworks;
	private boolean sound;
	
	public MahJongBoard(int seed)
	{
		removed = new Stack<TilePair>();
		bottomLayerZOrder = new ArrayList<>();
		
		fireworks = new Fireworks();
		sound = false;
		
		backgroundImg = new ImageIcon(MahJongBoard.class.getResource("/resources/dragon_bg.png"));
		backgroundImg = new ImageIcon(backgroundImg.getImage().getScaledInstance((int)(backgroundImg.getIconWidth() * 1.4), -1, Image.SCALE_SMOOTH));
		yellow = new Color(238, 192, 31);
		
		setLayout(null);
		
		model = new MahJongModel(seed);		
		
		placeTiles();
		
		this.addMouseListener(this);	
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(yellow);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(backgroundImg.getImage(), (this.getWidth() - backgroundImg.getIconWidth()) / 2, (this.getHeight() - backgroundImg.getIconHeight()) / 2, this);
	}
	
	public void placeTiles()
	{	
		for (int i = model.size() - 1; i >= 0; i--)
		{	
			TileLayer layer = model.get(i);
			for (int j = layer.size() - 1; j >= 0; j--)
			{
				TileRow row = layer.get(j);
				for (int k = 0; k < row.size(); k++) 
				{
					TileModel tile = row.get(k);
					if (tile != null && tile.tile.visible == true)
					{
						int xPos;
						int yPos;
						
						boolean special = false;
						
						// deal with the top tile
						if (i == 4)
						{
							xPos = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE)) + TILE_WIDTH / 2;
							yPos = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE)) + TILE_HEIGHT / 2;
						}
						// deal with the special cases - bottom layer three tiles
						else if ((i == 0 && j == 8 && k == 0) || (i == 0 && j == 3 && (k == 12 || k == 13)))
						{
							xPos = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE));
							yPos = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE)) + TILE_HEIGHT / 2;
							special = true;
						}
						else 
						{
							yPos = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE));
							xPos = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE));	
						}
						
						tile.tile.addMouseListener(this);
						tile.tile.setLocation(xPos, yPos); 
						add(tile.tile);
						
						/*
						// record the zorder of this current tile after it is added to the board
						tile.tile.setZOrder();
						*/
						
						if (special)
						{
							bottomLayerZOrder.add(getComponentZOrder(tile.tile));
						}
					}
				}
			}
		}	
	}
	
	public boolean isStarted()
	{
		return !removed.empty();
	}
	
	/********************************** game commands *****************************************/
	public void undo()
	{
		if (!removed.empty())
		{
			TilePair pair = removed.pop();
			Tile first = pair.first.tile;
			Tile second = pair.second.tile;
			
			add(first);
			first.setVisible(true);
			setComponentZOrder(first, first.getZOrder());
			
			add(second);
			second.setVisible(true);
			setComponentZOrder(second, second.getZOrder());
			
			revalidate();
			repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "There are no more moves to undo", "Failure Undo", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	public void displayRemoved(ReviewPane review)
	{
		JFrame reviewFrame = new JFrame();
		reviewFrame.add(review);
		reviewFrame.setSize(400, 250);
		reviewFrame.setVisible(true);
	}*/
	
	/********************************** game commands end ****************************************/

	public void setSound(boolean sound)
	{
		this.sound = sound;
	}
	
	public Stack<TilePair> getRemoved()
	{
		return this.removed;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		Tile tile = (Tile)e.getSource();
		int x = tile.x;
		int y = tile.y;
		int z = tile.z;
		
		// check to see if the tiles can be removed
		if (model.isTileOpen(new TileModel(tile, x, y, z)))
		{
			if (first == null)
			{
				first = new TileModel(tile, x, y, z);
				first.tile.setBorder(selected);
			}
			else if (first.tile == tile)
			{
				first.tile.setBorder(null);
				first = null;
			}
			else if (first.tile.matches(tile))
			{
				// put the removed tiles into a stack
				second = new TileModel(tile, x, y, z);
				second.tile.setBorder(selected);
				
				removed.push(new TilePair(first, second));
				
				first.tile.setZOrder(this.getComponentZOrder(first.tile));
				remove(first.tile);
				first.tile.setVisible(false);
				first.tile.setBorder(null);
				
				second.tile.setZOrder(this.getComponentZOrder(second.tile));
				remove(second.tile);
				second.tile.setVisible(false);
				second.tile.setBorder(null);
				
				first = second = null;
				
				if (sound)
				{
					PlayClip clip = new PlayClip("audio/stone-scraping.wav");
					clip.play();
				}
				
				// check to see if this is a winning move - if so, display fireworks and sound
				if (removed.size() == 72)
				{
					// display fireworks and play sound if it is not muted
					fireworks.setSound(sound);
					add(fireworks.getPanel());
					fireworks.fire();
					revalidate();
				}
			}
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
