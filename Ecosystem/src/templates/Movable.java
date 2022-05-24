package templates;


public interface Movable extends Positionable {
	void setSpeed(int speed);
	int getSpeed();
	void moveUp();
	void moveDown();
	void moveLeft();
	void moveRight();
}
