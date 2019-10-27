package assignment.animal;

import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.sound.SoundSilence;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.walk.WalkCannot;

public class Fish extends Animal {
    Fish(String name, Gender gender){
        super(name, AnimalCategory.FISH, gender, new SingNothing(), new WalkCannot(),
                new SwimCan(), new FlyCannot(), new SoundSilence());
    }
}
