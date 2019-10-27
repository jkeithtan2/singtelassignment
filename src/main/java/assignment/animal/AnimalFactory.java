package assignment.animal;

import assignment.animal.behaviour.fly.FlyCannot;
import assignment.animal.behaviour.fly.FlyWithWings;
import assignment.animal.behaviour.sing.SingBirdSongs;
import assignment.animal.behaviour.sing.SingNothing;
import assignment.animal.behaviour.sound.SoundChickenMakes;
import assignment.animal.behaviour.sound.SoundDuckMakes;
import assignment.animal.behaviour.swim.SwimCan;
import assignment.animal.behaviour.swim.SwimCannot;
import assignment.animal.behaviour.walk.WalkCan;
import assignment.animal.behaviour.walk.WalkCannot;


public class AnimalFactory {
    public static Animal createAnimal(String animal) {
        switch(animal.toLowerCase().trim()){
            case "duck":
                return Animal.builder()
                        .name("duck")
                        .category(AnimalCategory.BIRD)
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingBirdSongs())
                        .swimBehaviour(new SwimCan())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundDuckMakes())
                        .build();
            case "chicken":
                return Animal.builder()
                        .name("chicken")
                        .category(AnimalCategory.BIRD)
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingBirdSongs())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundChickenMakes())
                        .build();
        }
        return Animal.builder()
                .name("default animal")
                .gender(Gender.FEMALE)
                .flyBehaviour(new FlyCannot())
                .singBehaviour(new SingNothing())
                .swimBehaviour(new SwimCannot())
                .walkBehaviour(new WalkCannot())
                .build();
    }
}
