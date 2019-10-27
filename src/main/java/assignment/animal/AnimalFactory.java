package assignment.animal;

import assignment.behaviour.fly.FlyCannot;
import assignment.behaviour.fly.FlyWithWings;
import assignment.behaviour.growth.CaterpillarGrowth;
import assignment.behaviour.sing.SingBirdSongs;
import assignment.behaviour.sing.SingNothing;
import assignment.behaviour.sound.*;
import assignment.behaviour.swim.SwimCan;
import assignment.behaviour.swim.SwimCannot;
import assignment.behaviour.uniquefeatures.UniqueClownfishFeatures;
import assignment.behaviour.uniquefeatures.UniqueSharkFeatures;
import assignment.behaviour.walk.WalkCan;
import assignment.behaviour.walk.WalkCannot;


public class AnimalFactory {
    public static Animal createAnimal(String animal) {
        animal = animal.toLowerCase().trim();
        switch(animal){
            case "dog":
                return Animal.builder()
                        .name("dog")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundDogMakes())
                        .build();
            case "cat":
                return Animal.builder()
                        .name("cat")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundCatMakes())
                        .build();
            case "duck":
                return Animal.builder()
                        .name("duck")
                        .category(AnimalCategory.BIRD)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingBirdSongs())
                        .swimBehaviour(new SwimCan())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundDuckMakes())
                        .build();
            case "dolphin":
                return Animal.builder()
                        .name("dolphin")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCan())
                        .walkBehaviour(new WalkCannot())
                        .soundMakesBehaviour(new SoundSilence())
                        .build();
            case "butterfly":
                return Animal.builder()
                        .name("butterfly")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundSilence())
                        .build();
            case "caterpillar":
                return Animal.builder()
                        .name("caterpillar")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundSilence())
                        .growthBehaviour(new CaterpillarGrowth())
                        .build();
            case "chicken":
            case "rooster":
                return createChickenOrRooster(animal);
            case "fish":
            case "shark":
            case "clownfish":
                return createFish(animal);
            case "parrot":
                return createParrot(null);
        }
        return Animal.builder()
                .name("default animal")
                .flyBehaviour(new FlyCannot())
                .singBehaviour(new SingNothing())
                .swimBehaviour(new SwimCannot())
                .walkBehaviour(new WalkCannot())
                .build();
    }

    public static Animal createParrot(SoundMakesBehaviour soundAnimalParrotLivesWith) {
        return Animal.builder().name("parrot")
                .category(AnimalCategory.BIRD)
                .gender(Gender.FEMALE)
                .flyBehaviour(new FlyWithWings())
                .singBehaviour(new SingBirdSongs())
                .swimBehaviour(new SwimCannot())
                .walkBehaviour(new WalkCan())
                .soundMakesBehaviour(soundAnimalParrotLivesWith)
                .build();
    }

    private static Animal createChickenOrRooster(String type) {
        Animal animal = Animal.builder()
                .category(AnimalCategory.BIRD)
                .flyBehaviour(new FlyCannot())
                .singBehaviour(new SingBirdSongs())
                .swimBehaviour(new SwimCannot())
                .walkBehaviour(new WalkCan())
                .build();
        if (type.equals("rooster")) {
            animal.setGender(Gender.MALE);
            animal.setName("rooster");
            animal.setSoundMakesBehaviour(new SoundRoosterMakes());
        } else {
            animal.setGender(Gender.FEMALE);
            animal.setName("chicken");
            animal.setSoundMakesBehaviour(new SoundChickenMakes());
        }
        return animal;
    }

    private static Animal createFish(String type) {
        Animal animal = Animal.builder()
                .category(AnimalCategory.FISH)
                .flyBehaviour(new FlyCannot())
                .singBehaviour(new SingNothing())
                .swimBehaviour(new SwimCan())
                .walkBehaviour(new WalkCannot())
                .soundMakesBehaviour(new SoundSilence())
                .build();
        switch(type) {
            case "fish":
                animal.setName("fish");
                break;
            case "shark":
                animal.setName("shark");
                animal.setUniqueFeatures(new UniqueSharkFeatures());
                break;
            case "clownfish":
                animal.setName("clownfish");
                animal.setUniqueFeatures(new UniqueClownfishFeatures());
                break;
        }
        return animal;
    }
}
