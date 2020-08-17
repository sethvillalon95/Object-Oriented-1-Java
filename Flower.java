import java.awt.Graphics;
import java.awt.Point;
//import java.util.ArrayList;


import javax.swing.ImageIcon;

public class Flower extends Plant{
	//private ImageIcon image;
	//private Point pos;
	
	//constructors
	
	public Flower(int x, int y) {
		
		super(x,y);
		double r  = Math.random();
		
		if (r < .25) {
			image = new ImageIcon("flower0.png");
		} else if (r < .5) {
			image = new ImageIcon("flower1.png");
		} else if (r < .75) {
			image = new ImageIcon("flower2.png");
		} else {
			image = new ImageIcon("flower3.png");
		}
		
		
		
		
		/*flower0 = new ImageIcon("flower0.png");
		flower1 = new ImageIcon("flower1.png");
		flower2 = new ImageIcon("flower2.png");
		flower3 = new ImageIcon("flower3.png");
		
		ArrayList<E> flowers = new ArrayList();
		flowers.add(flower0);
		flowers.add(flower1);
		flowers.add(flower2);
		flowers.add(flower3);
		
		int size = flowers.size();
		var s = new Scanner(flowers);
		for (i = 0; i<size; i++ )
			image = i;*/
		
		
		}
	
	
	
	// method
	
	/*public void draw(Graphics g) {
		if (image != null) {
			image.paintIcon(null, g, pos.x,pos.y);
	} else {
		g.drawString("Flower", pos.x,pos.y);
		}
	}*/
}