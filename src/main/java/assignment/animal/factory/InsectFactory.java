package assignment.animal.factory;

import assignment.animal.Animal;
import assignment.animal.AnimalCategory;
import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.fly.FlyWithWings;
import assignment.behaviour.growth.ButterflyGrowthBehaviour;
import assignment.behaviour.growth.CaterpillarGrowthBehaviour;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.sound.SoundSilence;
import assignment.behaviour.swim.SwimCannot;
import assignment.behaviour.walk.WalkCan;

public class InsectFactory implements AbstractAnimalFactory{
    @Override
    public Animal create(String animalType) {
        animalType = animalType.toLowerCase().trim();
        switch (animalType) {
            case "butterfly":
                return Animal.builder()
                        .name("butterfly")
                        .category(AnimalCategory.INSECTS)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundSilence())
                        .growthBehaviour(new ButterflyGrowthBehaviour())
                        .build();
            case "caterpillar":
                return Animal.builder()
                        .name("caterpillar")
                        .category(AnimalCategory.INSECTS)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundSilence())
                        .growthBehaviour(new CaterpillarGrowthBehaviour())
                        .build();
        }
        return null;
    }
}
