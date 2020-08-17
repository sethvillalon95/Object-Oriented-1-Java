import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class  FlowerPower extends JPanel implements KeyListener{
	// field 
	private Garden seth;
	private ImageIcon bird1;
	private ImageIcon bird2;
	private MathProblem problem;
	public static final int MAIN_LOOP=1;
	public static final int ENDGAME =0;
	public int state = MAIN_LOOP;
	private int score = 0;
	private String playerName;
	private int attempt = 3;
	
	
	public FlowerPower() {
		seth = new Garden ();
		bird1 = new ImageIcon("bird.png");
		bird2 = new ImageIcon("bird.png");
		problem = new MathProblem();
		addKeyListener(this);
		playerName = JOptionPane.showInputDialog("Name:");
		
	}
	
	//method 
	public void paintComponent(Graphics g) {
		// background 
		 int w = getWidth();
		 int h = getHeight();
		
		// font 
		 g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		 
		// background 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, w, h);
		
		// grass
		g.setColor(Color.green);
		g.fillRect(0, h*4/5, w, h/4);
		
		//sun
		g.setColor(Color.yellow);
		g.fillOval(-100, -100, 200, 200);
				
		// bird 
		bird1.paintIcon(null, g, 400, 100);
		bird2.paintIcon(null, g, 400, 200);
		
		// score 
		g.drawString("SCORE: " + score, 150, 50);
		
		// name 
		g.drawString("Player:"+playerName, 400, 50);
		
		//number of attempts
		g.drawString("Attempts: "+ attempt,150,100 );
		
		seth.draw(g);
		if (state == MAIN_LOOP) {
			problem.draw(g);
		}else {
			g.drawString("Game Over!, Wanna play again? Press 'y'", 100, 300);
			g.drawString("If not, Press any key  ", 150, 400);
		}
		
		requestFocusInWindow();
		
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,600);
		window.setContentPane(new FlowerPower());
		window.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		// check the state of the player 
		if (state == MAIN_LOOP) {
				//instantiate a new problem
			   int blabla = problem.recieveUserInput(e);
			   if (blabla == seth.FLOWER ) {
				   // instantiate new flower 
				   seth.newFlower();
				   
					if (state == MAIN_LOOP) {
						 //check if the garden is full
						if (seth.isFull()==true) {
							state = ENDGAME;
						}
						else {
							problem = new MathProblem();
							// adding score 
							score = score+10;
							
							if( attempt < 3) {
								attempt = 3;
							}
						}
						
					}
			   }

			   else if (blabla == seth.WEED) {
				   // deducting number of attempts 
				   if (attempt != 0) {
					   attempt = attempt-1;
				   }
				   
				   // delete attempt if statement 
				   if (attempt == 0) {
					   seth.newWeed();
				   }
				   if (state == MAIN_LOOP) {
						 //check if the garden is full
						if (seth.isFull()==true) {
							state = ENDGAME;
						}
						else {
							// delete next line if something happens wrong
							if ( attempt < 1) {
								problem = new MathProblem();
								if (attempt == 0) {
									attempt = 3;
								}
								// Deducting score
								score =score-5;
							}
						}
					}
			   }
			   //KeyEvent.VK_ENTER;
			repaint();
		} 
		else  {
			int bla  = problem.keyBoard(e);
			if (bla == 1) {
				state = MAIN_LOOP;
				seth.clear();
				
			}
			else {
				System.exit(0);
			}
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
}
