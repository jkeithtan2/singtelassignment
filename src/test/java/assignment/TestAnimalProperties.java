package assignment;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
import assignment.animal.factory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAnimalProperties {
    private AbstractAnimalFactory animalFactory;

    @BeforeEach
    void setup() {
        this.animalFactory = new AnimalFactory();
    }

    @Test
    void chicken_shouldNotFlySwim_ShouldWalkSing_BelongsToBirds_clucks() {
        Animal chicken = animalFactory.create("chicken");
        assertEquals("birdsongs sung", chicken.sing());
        assertEquals("can walk", chicken.walk());
        assertEquals("cannot fly", chicken.fly());
        assertEquals("cannot swim", chicken.swim());
        assertEquals("Cluck, cluck", chicken.soundMakes());
        assertEquals( AnimalCategory.BIRD, chicken.getCategory());
    }

    @Test
    void rooster_shouldNotFlySwim_ShouldWalkSing_BelongsToBirds_clucks() {
        Animal rooster = animalFactory.create("rooster");
        assertEquals("birdsongs sung", rooster.sing());
        assertEquals("can walk", rooster.walk());
        assertEquals("cannot fly", rooster.fly());
        assertEquals("cannot swim", rooster.swim());
        assertEquals("Cock-a-doodle-doo", rooster.soundMakes());
        assertEquals( AnimalCategory.BIRD, rooster.getCategory());
    }

    @Test
    void duck_shouldFlySwimWalkSing_BelongsToBirds_quacks() {
        Animal duck = animalFactory.create("duck");
        assertEquals("birdsongs sung", duck.sing());
        assertEquals("can walk", duck.walk());
        assertEquals("can fly with wings", duck.fly());
        assertEquals("can swim", duck.swim());
        assertEquals("Quack, quack", duck.soundMakes());
        assertEquals( AnimalCategory.BIRD, duck.getCategory());
    }

    @Test
    void parrot_shouldWoofWhenLivingWithDog() {
        Animal parrotThatLivesWithDog = animalFactory.create("parrotLivesWithDog");
        assertEquals("Woof, woof", parrotThatLivesWithDog.soundMakes());
    }

    @Test
    void parrot_shouldMeowWhenLivingWithCat() {
        Animal parrotThatLivesWithCat = animalFactory.create("parrotLivesWithCat");
        assertEquals("Meow", parrotThatLivesWithCat.soundMakes());
    }

    @Test
    void parrot_shouldCockADoodlwDooWhenLivingWithRooster() {
        Animal parrotThatLivesWithRooster = animalFactory.create("parrotLivesWithRooster");
        assertEquals("Cock-a-doodle-doo", parrotThatLivesWithRooster.soundMakes());
    }

    @Test
    void parrot_shouldRingWhenLivingWithPhone() {
        Animal parrotThatLivesWithPhone = animalFactory.create("parrotLivesWithPhone");
        assertEquals("Ring, ring", parrotThatLivesWithPhone.soundMakes());
    }

    @Test
    void fish_shouldSwim_shouldNotWalkSingFly() {
        Animal fish = animalFactory.create("fish");
        assertEquals("fish", fish.getName());
        assertEquals("no songs sung", fish.sing());
        assertEquals("cannot walk", fish.walk());
        assertEquals("cannot fly", fish.fly());
        assertEquals("can swim", fish.swim());
    }

    @Test
    void shark_shouldHaveUniqueFeatures() {
        Animal shark = animalFactory.create("shark");
        assertEquals("large, grey and eats other fishes", shark.features());
    }

    @Test
    void clownfish_shouldHaveUniqueFeatures() {
        Animal clownfish = animalFactory.create("clownfish");
        assertEquals("Orange small and tells jokes", clownfish.features());
    }

    @Test
    void butterfly_shouldGrowFromCaterpillar() {
        Animal caterpillar = animalFactory.create("caterpillar");
        Animal caterpillarMorphedto = animalFactory.create(caterpillar.morphTo());
        assertEquals("butterfly", caterpillarMorphedto.getName());
        assertEquals("can fly with wings", caterpillarMorphedto.fly());
    }

    @Test
    void caterpillar_shouldGrowFromButterfly() {
        Animal butterfly = animalFactory.create("butterfly");
        Animal butterflyMorphedFrom = animalFactory.create(butterfly.morphFrom());
        assertEquals("caterpillar", butterflyMorphedFrom.getName());
        assertEquals("cannot fly", butterflyMorphedFrom.fly());
    }

    @Test
    void assertAnimalNumbersOfType() {
        List<String> animals = new ArrayList<>(
                Arrays.asList("duck", "chicken", "parrot", "rooster", "clownfish",
                        "shark", "butterfly", "cat", "caterpillar", "dog", "dolphin"));
        List<Animal> animalsObjList = animals
                .stream()
                .map(a -> animalFactory.create(a))
                .collect(Collectors.toList());
        assertEquals(3,
                AnimalUtils.animalCounterByCondition(animalsObjList, "canfly"));
        assertEquals(8,
                AnimalUtils.animalCounterByCondition(animalsObjList, "canwalk"));
        assertEquals(4,
                AnimalUtils.animalCounterByCondition(animalsObjList, "cansing"));
        assertEquals(4,
                AnimalUtils.animalCounterByCondition(animalsObjList, "canswim"));
    }
}
