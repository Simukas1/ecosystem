package Animal;

import templates.Movable;

public class MammalFactory extends AbstractFactory{

	public Movable getAnimal(String AnimalType) {
		if (AnimalType.equalsIgnoreCase("CAT")) {
			return new Cat();
		}
		else if (AnimalType.equalsIgnoreCase("DOG")) {
			return new Dog();
		}
		return null;
	}
	
}
