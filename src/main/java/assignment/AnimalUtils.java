package assignment;

import assignment.animal.Animal;
import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.swim.SwimCannot;
import assignment.behaviour.walk.WalkCannot;

import java.util.List;

public class AnimalUtils {
    public static long animalCounterByCondition(List<Animal> animals, String condition) {
        switch (condition) {
            case "canfly":
                return animals.stream().filter(a -> !a.fly().equals(new FlyCannot().fly())).count();
            case "canswim":
                return animals.stream().filter(a -> !a.swim().equals(new SwimCannot().swim())).count();
            case "cansing":
                return animals.stream().filter(a -> !a.sing().equals(new SingNothing().sing())).count();
            case "canwalk":
                return animals.stream().filter(a -> !a.walk().equals(new WalkCannot().walk())).count();
        }
        return 0;
    }
}
