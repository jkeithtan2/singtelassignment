package assignment.animal.factory;

import assignment.animal.Animal;

public interface AbstractAnimalFactory {
    Animal create(String animalType);
}
