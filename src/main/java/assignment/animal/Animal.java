package assignment.animal;

import assignment.behaviour.fly.FlyBehaviour;
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
@Setter
public class Animal {

    @Getter
    private String name;
    @Getter
    private AnimalCategory category;
    @Getter
    private Gender gender;
    private SingBehaviour singBehaviour;
    private WalkBehaviour walkBehaviour;
    private SwimBehaviour swimBehaviour;
    private FlyBehaviour flyBehaviour;
    private SoundMakesBehaviour soundMakesBehaviour;
    private UniqueFeatures uniqueFeatures;


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
}
