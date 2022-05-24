package Animal;

import templates.Positionable;

public class Ball implements Positionable {

	private int x, y;
	
	private boolean isPicked = false;
	
	public boolean isPicked() {
		return isPicked;
	}

	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}
	
	public Ball(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
