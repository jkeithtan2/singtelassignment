package assignment.animal;

import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.growth.GrowthBehaviour;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.sound.SoundMakesBehaviour;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.uniquefeatures.UniqueFeatures;
import assignment.behaviour.walk.WalkCannot;
import lombok.Builder;

public class Fish extends Animal {
    @Builder(builderMethodName = "fishBuilder")
    public Fish(String name, Gender gender, SoundMakesBehaviour soundMakesBehaviour,
                UniqueFeatures uniqueFeatures, GrowthBehaviour growthBehaviour) {
        super(name, AnimalCategory.FISH,
                gender, new SingNothing(), new WalkCannot(), new SwimCan(),
                new FlyCannot(), soundMakesBehaviour, uniqueFeatures, growthBehaviour);
    }
}
