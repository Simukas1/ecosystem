package Animal;

import templates.Movable;

public abstract class AbstractFactory {
	public abstract Movable getAnimal(String AnimalType);
}
