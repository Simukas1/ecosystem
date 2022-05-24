package Animal;

import java.io.Serializable;

public class Bird extends Animal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int z;
	private boolean isFlying;
	private char name = 'B';

	public char getName() {
		return name;
	}

	public Bird() {
		z=0;
		isFlying=false;
	}
	public Bird(int x, int y){
		setX(x);
		setY(y);
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
	
	public void stopFly() {
		z=0;
		isFlying=false;
	}
	
	public void startFly() {
		z=20;
		isFlying=true;
	}
}
