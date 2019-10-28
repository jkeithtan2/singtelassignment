package assignment.animal.factory;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.sound.SoundCatMakes;
import assignment.behaviour.sound.SoundDogMakes;
import assignment.behaviour.sound.SoundSilence;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.swim.SwimCannot;
import assignment.behaviour.walk.WalkCan;
import assignment.behaviour.walk.WalkCannot;

public class MammalFactory implements AbstractAnimalFactory {
    @Override
    public Animal create(String animalType) {
        animalType = animalType.toLowerCase().trim();
        switch (animalType) {
            case "dog":
                return Animal.builder()
                        .name("dog")
                        .category(AnimalCategory.MAMMALS)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundDogMakes())
                        .build();
            case "cat":
                return Animal.builder()
                        .name("cat")
                        .category(AnimalCategory.MAMMALS)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundCatMakes())
                        .build();
            case "dolphin":
                return Animal.builder()
                        .name("dolphin")
                        .category(AnimalCategory.MAMMALS)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCan())
                        .walkBehaviour(new WalkCannot())
                        .soundMakesBehaviour(new SoundSilence())
                        .build();
        }
        return null;
    }
}
