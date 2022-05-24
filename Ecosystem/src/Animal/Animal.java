package Animal;

import templates.Movable;

import java.io.Serializable;


public class Animal implements Movable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y, speed;
	private boolean isAlive;
	private char name;

	public Animal() {
		x = y = 0;
		speed = 2;
		isAlive = true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void moveUp()  {
		y-=speed;
	}
	
	public void moveDown()  {
		y+=speed;
	}
	
	public void moveRight()  {
		x+=speed;
	}
	
	public void moveLeft()  {
		x-=speed;
	}
	
	public boolean isInMap(int w, int h) {
		if (x<0 || y<0 || x>=w || y>=h) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Animal [x=" + x + ", y=" + y + ", speed=" + speed + ", isAlive=" + isAlive + "]";
	}


	public char getName() {
		return name;
	}

	public void sneak() {};
	public void stopSneak(){};
}
