import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CircleTile extends RankTile 
{

    private ArrayList<Circle> circles;
    Color crimson;
    Color limegreen;
    Color royalblue;
    
    private void addCircle(int xCount, int yCount, int xpos, int ypos, int radius, Color color) 
    {
    		int xl = size / xCount;
    		int yl = size / yCount;
    		int x = (xl - radius * 2) / 2;
    		int y = (yl - radius * 2) / 2;
    		circles.add(new Circle(faceX + x + radius + xpos * xl, radius + y + ypos * yl, radius, color));
    }

    public CircleTile(int rank) {
        
    		super(rank);
        circles = new ArrayList<>();
        crimson = new Color(220, 20, 60);
        limegreen = new Color(50, 205, 50);
        royalblue = new Color(58, 95, 205);
        
        int radius; 
        int xcnt;
        int ycnt;
        
        switch (rank) {
            case 1:
            		radius = size / 2 - 4;
                circles.add(new PancakeCircle(faceX + size / 2, size / 2, radius));
                break;
            case 2:
            		radius = size / 5;
            		xcnt = 1;
            		ycnt = 2;
            		addCircle(xcnt, ycnt, 0, 0, radius, crimson);
            		addCircle(xcnt, ycnt, 0, 1, radius, royalblue);
                break;
            case 3:
            		radius = size / 5 - 4;
            		xcnt = 3;
            		ycnt = 3;
            		addCircle(xcnt, ycnt, 0, 0, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 2, 2, radius, limegreen);
                break;
            case 4:
            		radius = size / 5;
            		xcnt = 2;
            		ycnt = 2;
            		addCircle(xcnt, ycnt, 0, 0, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 0, 1, radius, limegreen);
            		addCircle(xcnt, ycnt, 1, 1, radius, royalblue);
                break;
            case 5:
            		radius = size / 5 - 4;
            		xcnt = 3;
            		ycnt = 3;
            		addCircle(xcnt, ycnt, 0, 0, radius, royalblue);
            		addCircle(xcnt, ycnt, 2, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 1, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 0, 2, radius, limegreen);
            		addCircle(xcnt, ycnt, 2, 2, radius, royalblue);
            		break;
            case 6:
            		radius = size / 5 - 4;
            		xcnt = 2;
            		ycnt = 3;
            		addCircle(xcnt, ycnt, 0, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 0, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 0, 2, radius, crimson);
            		addCircle(xcnt, ycnt, 1, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 1, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 1, 2, radius, crimson);
                break;
            case 7:
            		radius = size / 8;
                circles.add(new Circle(faceX + (size / 6), (2 * size / 10), radius, limegreen));
                circles.add(new Circle(faceX + (3 * size / 6), (3 * size / 10), radius, limegreen));
                circles.add(new Circle(faceX + (5 * size / 6), (4 * size / 10), radius, limegreen));

                circles.add(new Circle(faceX + (2 * size / 7), (6 * size / 10 + 2), radius, crimson));
                circles.add(new Circle(faceX + (5 * size / 7), (6 * size / 10 + 2), radius, crimson));
                circles.add(new Circle(faceX + (2 * size / 7), (8 * size / 10 + 5), radius, crimson));
                circles.add(new Circle(faceX + (5 * size / 7), (8 * size / 10 + 5), radius, crimson));
                break;
            case 8:
            		radius = size / 8;
            		xcnt = 2;
            		ycnt = 4;
            		addCircle(xcnt, ycnt, 0, 0, radius, royalblue);
            		addCircle(xcnt, ycnt, 0, 1, radius, royalblue);
            		addCircle(xcnt, ycnt, 0, 2, radius, royalblue);
            		addCircle(xcnt, ycnt, 0, 3, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 0, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 1, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 2, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 3, radius, royalblue);
                break;
            case 9:
            		radius = size / 6 - 1;
            		xcnt = 3;
            		ycnt = 3;
            		
            		addCircle(xcnt, ycnt, 0, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 1, 0, radius, limegreen);
            		addCircle(xcnt, ycnt, 2, 0, radius, limegreen);
            		
            		addCircle(xcnt, ycnt, 0, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 1, 1, radius, crimson);
            		addCircle(xcnt, ycnt, 2, 1, radius, crimson);
            		
            		addCircle(xcnt, ycnt, 0, 2, radius, royalblue);
            		addCircle(xcnt, ycnt, 1, 2, radius, royalblue);
            		addCircle(xcnt, ycnt, 2, 2, radius, royalblue);
                break;
        }
        setToolTipText(toString());
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Circle c : circles)
        {
            c.draw(g);
        }
    }

    public String toString() {
        return "Circle " + rank;
    }

    class Circle
    {
        protected int x, y, r;
        protected Color color;
        
        Circle(int x, int y, int r, Color color)
        {
            this.x = x; 
            this.y = y; 
            this.r = r;
            this.color = color;
        }
        
        public void draw(Graphics g)
        {
            //Color prev = g.getColor();
            g.setColor(color);
            g.fillOval(x - r, y - r, 2 * r, 2 * r);
            
            // Draw the cross in the middle
            g.setColor(Color.WHITE);    
            int l = r - 3;
            double c = (l * Math.cos(Math.PI / 4));
            double s = (l * Math.sin(Math.PI / 4));
            g.drawLine((int)Math.round(x + c), (int)Math.round(y - s),
                       (int)Math.round(x - c), (int)Math.round(y + s));       
            g.drawLine((int)Math.round(x - c), (int)Math.round(y - s),
                       (int)Math.round(x + c), (int)Math.round(y + s));

            //g.setColor(prev);
        }
    }
    
    class PancakeCircle extends Circle
    {
        private int outerR;
        
        PancakeCircle(int x, int y, int r)
        {
            super(x, y, r/4, crimson);
            outerR = r;
        }

        @Override
        public void draw(Graphics g)
        {
        	    g.setColor(limegreen);
            g.fillOval(x - outerR, y - outerR, outerR * 2, outerR * 2);
            g.setColor(Color.BLACK);
            g.drawOval(x - outerR, y - outerR, outerR * 2, outerR * 2);

            // Draw border of circles
            g.setColor(Color.WHITE);
            int csR = outerR - 5;
            	int cR = 2;
            int n = (int)Math.round(csR * Math.PI / (cR * 2));
            
            for(double d = 0; d < (2 * Math.PI); d += (2 * Math.PI) / n)
            {
                g.fillOval((int)Math.round((x + csR*Math.cos(d)) - cR),
                           (int)Math.round((y - csR*Math.sin(d)) - cR), cR * 2, cR * 2);
            }

            g.setColor(color);
            g.fillOval(x - r, y - r, r * 2, r * 2);
            g.setColor(Color.WHITE);
            g.drawOval(x - r, y - r, r * 2, r * 2);
            
            int l = r - 3;
            double c = (l * Math.cos(Math.PI / 4));
            double s = (l * Math.sin(Math.PI / 4));
            g.drawLine((int)Math.round(x + c), (int)Math.round(y - s),
                       (int)Math.round(x - c), (int)Math.round(y + s));
            g.drawLine((int)Math.round(x - c), (int)Math.round(y - s),
                       (int)Math.round(x + c), (int)Math.round(y + s));
        }
    }
    
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}