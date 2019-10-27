package assignment;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
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
    void chicken_shouldNotFlySwim_ShouldWalkSing_BelongsToBirds() {
        Animal chicken = AnimalFactory.createAnimal("chicken");
        assertEquals("birdsongs sung", chicken.sing());
        assertEquals("can walk", chicken.walk());
        assertEquals("cannot fly", chicken.fly());
        assertEquals("cannot swim", chicken.swim());
        assertEquals( AnimalCategory.BIRD, chicken.getCategory());
    }

    @Test
    void duck_shouldFlySwimWalkSing_BelongsToBirds() {
        Animal duck = AnimalFactory.createAnimal("duck");
        assertEquals("birdsongs sung", duck.sing());
        assertEquals("can walk", duck.walk());
        assertEquals("can fly with wings", duck.fly());
        assertEquals("can swim", duck.swim());
        assertEquals( AnimalCategory.BIRD, duck.getCategory());
    }

}
