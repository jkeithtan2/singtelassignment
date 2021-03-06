package assignment.animal;

import assignment.behaviour.fly.FlyBehaviour;
import assignment.behaviour.growth.GrowthBehaviour;
import assignment.behaviour.sing.SingBehaviour;
import assignment.behaviour.sound.SoundMakesBehaviour;
import assignment.behaviour.swim.SwimBehaviour;
import assignment.behaviour.uniquefeatures.UniqueFeatures;
import assignment.behaviour.walk.WalkBehaviour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Animal {

    private String name;
    private AnimalCategory category;
    private Gender gender;
    private SingBehaviour singBehaviour;
    private WalkBehaviour walkBehaviour;
    private SwimBehaviour swimBehaviour;
    private FlyBehaviour flyBehaviour;
    private SoundMakesBehaviour soundMakesBehaviour;
    private UniqueFeatures uniqueFeatures;
    private GrowthBehaviour growthBehaviour;

    public String sing() {
        return singBehaviour.sing();
    }

    public String walk() {
        return walkBehaviour.walk();
    }

    public String swim() {
        return swimBehaviour.swim();
    }

    public String fly() {
        return flyBehaviour.fly();
    }

    public String soundMakes() {
        return soundMakesBehaviour.soundMakes();
    }

    public String features() {
        return uniqueFeatures.features();
    }

    public String morphTo() {
        return growthBehaviour.morphTo();
    }

    public String morphFrom() {
        return growthBehaviour.morphFrom();
    }
}
