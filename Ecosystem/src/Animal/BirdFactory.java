package Animal;

import templates.Movable;

public class BirdFactory extends AbstractFactory {
	
	@Override
	public Movable getAnimal(String AnimalType) {
		if (AnimalType.equalsIgnoreCase("BIRD")) {
			return new Bird();
		}
		return null;
	}
	
}
