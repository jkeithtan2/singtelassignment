package assignment;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
import assignment.animal.AnimalFactory;
import assignment.behaviour.sound.SoundPhoneMakes;
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
    void chicken_shouldNotFlySwim_ShouldWalkSing_BelongsToBirds_clucks() {
        Animal chicken = AnimalFactory.createAnimal("chicken");
        assertEquals("birdsongs sung", chicken.sing());
        assertEquals("can walk", chicken.walk());
        assertEquals("cannot fly", chicken.fly());
        assertEquals("cannot swim", chicken.swim());
        assertEquals("Cluck, cluck", chicken.soundMakes());
        assertEquals( AnimalCategory.BIRD, chicken.getCategory());
    }

    @Test
    void rooster_shouldNotFlySwim_ShouldWalkSing_BelongsToBirds_clucks() {
        Animal rooster = AnimalFactory.createAnimal("rooster");
        assertEquals("birdsongs sung", rooster.sing());
        assertEquals("can walk", rooster.walk());
        assertEquals("cannot fly", rooster.fly());
        assertEquals("cannot swim", rooster.swim());
        assertEquals("Cock-a-doodle-doo", rooster.soundMakes());
        assertEquals( AnimalCategory.BIRD, rooster.getCategory());
    }

    @Test
    void duck_shouldFlySwimWalkSing_BelongsToBirds_quacks() {
        Animal duck = AnimalFactory.createAnimal("duck");
        assertEquals("birdsongs sung", duck.sing());
        assertEquals("can walk", duck.walk());
        assertEquals("can fly with wings", duck.fly());
        assertEquals("can swim", duck.swim());
        assertEquals("Quack, quack", duck.soundMakes());
        assertEquals( AnimalCategory.BIRD, duck.getCategory());
    }

    @Test
    void parrot_shouldWoofWhenLivingWithDog() {
        Animal parrotThatLivesWithDog = AnimalFactory.createParrot(
                AnimalFactory.createAnimal("dog").getSoundMakesBehaviour()
        );
        assertEquals("Woof, woof", parrotThatLivesWithDog.soundMakes());
    }

    @Test
    void parrot_shouldMeowWhenLivingWithCat() {
        Animal parrotThatLivesWithCat = AnimalFactory.createParrot(
                AnimalFactory.createAnimal("cat").getSoundMakesBehaviour()
        );
        assertEquals("Meow", parrotThatLivesWithCat.soundMakes());
    }

    @Test
    void parrot_shouldCockADoodlwDooWhenLivingWithRooster() {
        Animal parrotThatLivesWithRooster = AnimalFactory.createParrot(
                AnimalFactory.createAnimal("rooster").getSoundMakesBehaviour()
        );
        assertEquals("Cock-a-doodle-doo", parrotThatLivesWithRooster.soundMakes());
    }

    @Test
    void parrot_shouldRingWhenLivingWithPhone() {
        Animal parrotThatLivesWithPhone = AnimalFactory.createParrot(new SoundPhoneMakes());
        assertEquals("Ring, ring", parrotThatLivesWithPhone.soundMakes());
    }
    
    @Test
    void fish_shouldSwim_shouldNotWalkSingFly() {
        Animal fish = AnimalFactory.createAnimal("fish");
        assertEquals("fish", fish.getName());
        assertEquals("no songs sung", fish.sing());
        assertEquals("cannot walk", fish.walk());
        assertEquals("cannot fly", fish.fly());
        assertEquals("can swim", fish.swim());
    }
}
