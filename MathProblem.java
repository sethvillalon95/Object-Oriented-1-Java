import java.awt.Graphics;
import java.awt.event.KeyEvent;






public class MathProblem  {
	//fields 
	private int num1;
	private int num2;
	private int answer;
	private String operator;
	private String userInput;
	
	
	public MathProblem(){
		
		userInput = "";
		
		var han = Math.random();
		if(han < 0.25) {
			operator = "+";
			num1 = (int)(Math.random()*13); 	
			num2 = (int)(Math.random()*13);
			answer = num1 + num2;
		}else if(han < .5) {
			operator = "-";
			num1 = (int)(Math.random()*13);
			num2 = (int)(Math.random()*13);
			if(num2 > num1) {
				var tori =num1;
				num1=num2;
				num2=tori;
			}
			answer = num1 - num2;
		}else if(han <.75) {
			operator = "*";
			num1 = (int)(Math.random()*13);
			num2 = (int)(Math.random()*13);
			answer = num1 * num2;
		}else {
			operator = "/";
			num1 = (int)(Math.random()*13);
			num2 = (int)(Math.random()*13);
			if(num2 == 0) {
				num2=num1;
			}
			answer = num1/num2;
		}
			
	}
	
	public void draw(Graphics g) {
		String num01 = Integer.toString(num1);
		String num02 = Integer.toString(num2);
		String equalSign = "=";
		
		g.drawString(num01 +" " + operator + num02 + equalSign + userInput , 300, 250);
		System.out.println(answer);
	}
	
	// method adding the user's Keystrokes 
	public int recieveUserInput(KeyEvent ke) {
		char charot = ke.getKeyChar();
		if ( charot >= '0' && charot <= '9' && userInput.length()<3) {
			
			userInput = userInput+charot;
				
		}
		
		// backspace
		int backSpace = KeyEvent.VK_BACK_SPACE;
		int codeGetter = ke.getKeyCode();
		if( codeGetter == backSpace) {
		     // testing the controls System.out.println("hello");
			int lengthOfUserInput = userInput.length();
			userInput = userInput.substring(0,lengthOfUserInput-1);
				
		 
						
			}
		
		
		int quinn =ke.getKeyCode();
		if (quinn == KeyEvent.VK_ENTER) {
			if(answer == Integer.parseInt(userInput)) {
				return Garden.FLOWER;
			}
			else {
				return Garden.WEED;
			}
		}
		return Garden.CONTINUE;
		
	}
	// method for the keyboard letters
	public int keyBoard(KeyEvent e) {
		char letter = e.getKeyChar();
		if (letter == 'y') {
			return 1;
		}
		return 0;
	}


		
	}
