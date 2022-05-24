package Animal;

import java.io.Serializable;


public class Dog extends Animal implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean runMode;
	private char name = 'D';

	public char getName() {
		return name;
	}
	private Ball ball;
	
	public void setRunMode(boolean runMode) {
		this.runMode=runMode;
	}
	
	public boolean getRunMode() {
		return runMode;
	}
	
	public Dog() {
		runMode=false;
			setSpeed(2);
	}
	public Dog(int x, int y){
		setX(x);
		setY(y);
	}

	
	public void run()  {
		setSpeed(5);
		runMode=true;
	}
	
	public void stopRun() {
		setSpeed(2);
		runMode=false;
	}
	
	public void pickBall(Ball ball) {
		if (getX() == ball.getX() && getY() == ball.getY()) {
			this.setBall(ball);
			ball.setPicked(true);
		}
	}


	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}
	
	public Object clone() {
		try {
			Dog clone = (Dog) super.clone();
			
			if (this.ball != null) {
				clone.ball = (Ball) this.ball.clone();
			}
			return clone;
		} catch (CloneNotSupportedException exc) {
			throw new Error("Cant create clone!" + exc.getMessage());
		}
	}
}
