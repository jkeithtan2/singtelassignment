package assignment;

import assignment.animal.Animal;
import assignment.animal.AnimalFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAnimalProperties {
    @Test
    void defaultAnimal_ShouldNotFlyWalkSingSwim() {
        Animal defaultAnimal = AnimalFactory.createAnimal("random");
        assertEquals("no songs sung", defaultAnimal.sing());
        assertEquals("cannot walk", defaultAnimal.walk());
        assertEquals("cannot fly", defaultAnimal.fly());
        assertEquals("cannot swim", defaultAnimal.swim());

    }

    @Test
    void bird_shouldFlyWalkSingshouldnotSwim() {
        Animal bird = AnimalFactory.createAnimal("bird");
        assertEquals("birdsongs sung", bird.sing());
        assertEquals("can walk", bird.walk());
        assertEquals("can fly with wings", bird.fly());
        assertEquals("cannot swim", bird.swim());
    }
}
