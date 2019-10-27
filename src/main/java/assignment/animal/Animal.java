package assignment.animal;

import assignment.animal.behaviour.fly.FlyBehaviour;
import assignment.animal.behaviour.sing.SingBehaviour;
import assignment.animal.behaviour.swim.SwimBehaviour;
import assignment.animal.behaviour.walk.WalkBehaviour;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter @Setter
public class Animal {

    private String name;
    private AnimalCategory category;
    private Gender gender;
    private SingBehaviour singBehaviour;
    private WalkBehaviour walkBehaviour;
    private SwimBehaviour swimBehaviour;
    private FlyBehaviour flyBehaviour;


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
}
