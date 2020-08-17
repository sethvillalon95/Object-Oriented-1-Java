import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Weed extends Plant {
	// fields 
	
	//private ImageIcon image;
	//private Point pos;

	public Weed(int x, int y) {
		super(x,y);
		//pos = new Point (x,y);
		image = new ImageIcon("weed.png");
		
	}
	
	// method 
	/*public void draw(Graphics g) {
		if(image != null) {
		image.paintIcon(null, g, pos.x, pos.y);
		
		} else {
			g.drawString("Weed", pos.x, pos.y);
		}
	}	*/
}
