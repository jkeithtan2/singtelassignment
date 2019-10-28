package assignment.animal.factory;

import assignment.animal.Animal;
import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.uniquefeatures.UniqueClownfishFeatures;
import assignment.behaviour.uniquefeatures.UniqueSharkFeatures;
import assignment.behaviour.walk.WalkCannot;

public class FishFactory implements AbstractAnimalFactory {
    @Override
    public Animal create(String animalType) {
        animalType = animalType.toLowerCase().trim();
        Animal fish = Animal.builder()
                .walkBehaviour(new WalkCannot())
                .singBehaviour(new SingNothing())
                .swimBehaviour(new SwimCan())
                .flyBehaviour(new FlyCannot())
                .build();
        switch(animalType) {
            case "fish":
                fish.setName("fish");
                return fish;
            case "shark":
                fish.setName("shark");
                fish.setUniqueFeatures(new UniqueSharkFeatures());
                return  fish;
            case "clownfish":
                fish.setName("clownfish");
                fish.setUniqueFeatures(new UniqueClownfishFeatures());
                return fish;
        }
        return null;
    }
}
