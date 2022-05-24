package Animal;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean huntMode;
	private final char name = 'C';
	public char getName() {
		return name;
	}

	
	public boolean isHuntMode() {
		return huntMode;
	}

	public void setHuntMode(boolean huntMode) {
		this.huntMode = huntMode;
	}
	
	public Cat() {
		setSpeed(2);
	}
	public Cat(int x, int y){
		setX(x);
		setY(y);
	}

	
	public void sneak()  {
		setSpeed(1);
		huntMode=true;
	}
	
	public void stopSneak() {
		setSpeed(2);
		huntMode=false;
	}
	
}
