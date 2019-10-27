package assignment.behaviour.growth;

import assignment.animal.Animal;
import assignment.animal.AnimalFactory;

public class CaterpillarGrowth implements GrowthBehaviour {
    @Override
    public Animal morphTo() {
        return AnimalFactory.createAnimal("butterfly");
    }
}
