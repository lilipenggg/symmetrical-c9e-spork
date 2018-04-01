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
						int horizontal = 5 + ((tile.x * TILE_WIDTH) + (tile.z * TILE_EDGE));
						int vertical = 5 + ((tile.y * TILE_HEIGHT) - (tile.z * TILE_EDGE));
						
						tile.tile.addMouseListener(this);
						tile.tile.setLocation(horizontal, vertical); 
						add(tile.tile, -1);
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
