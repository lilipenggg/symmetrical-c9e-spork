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
	
	// data member used for keeping track of the range of ZOrder for each layer
	private ArrayList<int[]> zOrderRanges;
	
	// data member used to store the zorder of the special case tiles at the bottom layer
	private ArrayList<Integer> bottomLayerZOrder;
	
	// border that highlights the selected tile
	private Border selected = BorderFactory.createLineBorder(Color.RED, 2);
	
	public MahJongBoard()
	{
		removed = new Stack<TilePair>();
		zOrderRanges = new ArrayList<int[]>();
		bottomLayerZOrder = new ArrayList<>();
		
		backgroundImg = new ImageIcon(MahJongBoard.class.getResource("/resources/dragon_bg.png"));
		backgroundImg = new ImageIcon(backgroundImg.getImage().getScaledInstance((int)(backgroundImg.getIconWidth() * 1.4), -1, Image.SCALE_SMOOTH));
		yellow = new Color(238, 192, 31);
		
		setLayout(null);
		
		model = new MahJongModel();		
		
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
		int[] range;
		int counter = 0;
		
		for (int i = model.size() - 1; i >= 0; i--)
		{
			range = new int[2];
			
			TileLayer layer = model.get(i);
			for (int j = layer.size() - 1; j >= 0; j--)
			{
				TileRow row = layer.get(j);
				for (int k = 0; k < row.size(); k++) 
				{
					TileModel tile = row.get(k);
					if (tile != null && tile.tile.isVisible() == true)
					{
						int xPos;
						int yPos;
						
						boolean special = false;
						
						// keep track of the zoreder range
						if (k == 0 && j == layer.size() -1)
							range[0] = counter;
						
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
						
						// record the zorder of this current tile after it is added to the board
						tile.tile.setZOrder();
						
						if (special)
						{
							bottomLayerZOrder.add(getComponentZOrder(tile.tile));
						}
						
						if (!(k == row.size() - 1 && j == 0))
							counter++;
					}
				}
			}
			range[1] = counter;
			zOrderRanges.add(range);
		}	
	}
	
	public void undo()
	{
		if (!removed.empty())
		{
			TilePair pair = this.removed.pop();
			Tile first = pair.first.tile;
			Tile second = pair.second.tile;
			add(first, first.getZOrder());
			add(second, second.getZOrder());
		}
		else
		{
			JOptionPane.showMessageDialog(this, "There are no more moves to undo", "Failure Undo", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		int x = 0;
		int y = 0;
		int z = 0;
		
		Tile tile = (Tile)e.getSource();
		
		// retrieve the layer number z for this tile
		int zOrder = getComponentZOrder(tile);
		
		for(int i = 0; i < zOrderRanges.size(); i++)
		{
			if (zOrder >= zOrderRanges.get(i)[0] && zOrder <= zOrderRanges.get(i)[1])
			{
				z = zOrderRanges.size() - 1 - i;
				break;
			}
		}
		
		// compute x and y index value for this tile based on different scenario
		if (z == 4)
		{
			x = (tile.getX() - 5 - (TILE_WIDTH / 2) - (z * TILE_EDGE)) / TILE_WIDTH;
			y = (tile.getY() - 5 - (TILE_HEIGHT / 2) + (z * TILE_EDGE)) / TILE_HEIGHT;	
		}
		else if (bottomLayerZOrder.contains(zOrder))
		{
			x = (tile.getX() - 5 - (z * TILE_EDGE)) / TILE_WIDTH;
			y = (tile.getY() - 5 - (TILE_HEIGHT / 2) + (z * TILE_EDGE)) / TILE_HEIGHT;
		}
		else
		{
			x = (tile.getX() - 5 - z * TILE_EDGE) / TILE_WIDTH;
			y = (tile.getY() - 5 + z * TILE_EDGE) / TILE_HEIGHT;
		}
		
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
				
				first.tile.setBorder(null);
				second.tile.setBorder(null);
				// remove the first and second selected tiles from the borad
				remove(first.tile);
				remove(second.tile);
				
				first = second = null;
				
				repaint();
				
				// check to see if this is a winning move - if so, display fireworks and sound
				if (removed.size() == 72)
				{
					repaint();
					// display fireworks and sound
					
					revalidate();
				}
			}
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
