import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Garden {
	// fields
	private ArrayList<Plant> plants;
    //public ArrayList<Plant> plants;
	int x ;
	int y ;
	public static final int CONTINUE = 0;
	public static final int FLOWER =1 ;
	public static final int WEED = 2;
	
	
	

	// constructor
	public Garden() {		
	//  insttantiate the arraylist and the method
		plants = new ArrayList<>();
		 x = 0;
		 y = 450;
		 
		 
		
	
	}
	//method 
	public void draw(Graphics g) {
		for (var p : plants) {
			p.draw(g);
		
		}
			
	}
	public void newFlower() {
			
			plants.add(new Flower(x, y) );
			x+= 25;
			if(y== 400) {
				y+= 50;
			}else {
				y-= 50;
			
		}
		
	  
	}
	public void newWeed() {
		
			plants.add(new Weed(x, y) );
			x+= 25;
			if(y== 400) {
				y+= 50;
			}else {
				y-= 50;
			
		}
	}
	
	public void clear() {
		plants.clear();
		x = 0;
		y = 450;
	}
	public boolean isFull() {
		if(plants.size()== 16)
			return true;
		else {
			return false;
		}
	}

	


	
	
}
