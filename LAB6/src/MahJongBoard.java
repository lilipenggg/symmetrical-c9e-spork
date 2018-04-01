import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MahJongBoard extends JPanel implements MouseListener
{
	private MahJongModel model;
	
	private int TILE_WIDTH = 86;
	private int TILE_HEIGHT = 86;
	private int TILE_EDGE = 14;
	
	public MahJongBoard()
	{
		setLayout(null);
		
		model = new MahJongModel();		
		
		placeTile();
		
		this.addMouseListener(this);	
	}
	
	public void placeTile()
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
					if (tile != null && tile.isVisible() == true)
					{
						int horizontal;
						int vertical;
						
						/* deal with the top tile */
						if (i == 4)
						{
							horizontal = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE)) + TILE_WIDTH / 2;
							vertical = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE)) + TILE_HEIGHT / 2;
						}
						/* deal with the special cases - bottom layer three tiles*/
						else if ((i == 0 && j == 8 && k == 0) || (i == 0 && j == 3 && (k == 12 || k == 13)))
						{
							horizontal = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE));
							vertical = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE)) + TILE_HEIGHT / 2;
						}
						else 
						{
							vertical = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE));
							horizontal = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE));	
						}
						
						tile.tile.addMouseListener(this);
						tile.tile.setLocation(horizontal, vertical); 
						add(tile.tile);
					}
				}
				
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
