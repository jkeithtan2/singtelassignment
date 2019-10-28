package assignment.animal.factory;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
import assignment.animal.Gender;
import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.fly.FlyWithWings;
import assignment.behaviour.sing.SingBirdSongs;
import assignment.behaviour.sound.*;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.swim.SwimCannot;
import assignment.behaviour.walk.WalkCan;

public class BirdFactory implements AbstractAnimalFactory {
    @Override
    public Animal create(String animalType) {
        animalType = animalType.toLowerCase().trim();
        Animal bird = Animal.builder()
                .category(AnimalCategory.BIRD)
                .flyBehaviour(new FlyWithWings())
                .singBehaviour(new SingBirdSongs())
                .swimBehaviour(new SwimCannot())
                .walkBehaviour(new WalkCan())
                .build();
        switch (animalType) {
            case "rooster":
                bird.setGender(Gender.MALE);
                bird.setName("rooster");
                bird.setFlyBehaviour(new FlyCannot());
                bird.setSoundMakesBehaviour(new SoundRoosterMakes());
                return bird;
            case "chicken":
                bird.setGender(Gender.FEMALE);
                bird.setFlyBehaviour(new FlyCannot());
                bird.setName("chicken");
                bird.setSoundMakesBehaviour(new SoundChickenMakes());
                return bird;
            case "duck":
                bird.setName("duck");
                bird.setSwimBehaviour(new SwimCan());
                bird.setSoundMakesBehaviour(new SoundDuckMakes());
                return bird;
            case "parrot":
                return bird;
            case "parrotliveswithdog":
                bird.setSoundMakesBehaviour(new SoundDogMakes());
                return bird;
            case "parrotliveswithrooster":
                bird.setSoundMakesBehaviour(new SoundRoosterMakes());
                return bird;
            case "parrotliveswithcat":
                bird.setSoundMakesBehaviour(new SoundCatMakes());
                return bird;
            case "parrotliveswithphone":
                bird.setSoundMakesBehaviour(new SoundPhoneMakes());
                return bird;
        }
        return null;
    }
}
