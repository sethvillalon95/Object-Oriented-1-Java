import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class  Plant {
	// fields 
	protected ImageIcon image;
	protected Point pos;
	
	//constructor
	public Plant (int x, int y) {
		pos = new Point (x,y);
	}

	
	// method 
		public void draw(Graphics g) {
			//if(image != null) {
			image.paintIcon(null, g, pos.x, pos.y);
			
			//} else {
			//	g.drawString("plant", pos.x, pos.y);
			//}
		}	
	
}
