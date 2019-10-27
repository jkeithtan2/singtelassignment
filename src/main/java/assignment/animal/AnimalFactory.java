package assignment.animal;

import assignment.animal.behaviour.fly.FlyCannot;
import assignment.animal.behaviour.fly.FlyWithWings;
import assignment.animal.behaviour.sing.SingBirdSongs;
import assignment.animal.behaviour.sing.SingNothing;
import assignment.animal.behaviour.swim.SwimCannot;
import assignment.animal.behaviour.walk.WalkCan;
import assignment.animal.behaviour.walk.WalkCannot;

public class AnimalFactory {
    public static Animal createAnimal(String animal) {
        switch(animal.toLowerCase().trim()){
            case "bird":
                return Animal.builder()
                        .name("bird")
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingBirdSongs())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
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
