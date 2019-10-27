package assignment.animal;

import assignment.animal.behaviour.fly.FlyCannot;
import assignment.animal.behaviour.fly.FlyWithWings;
import assignment.animal.behaviour.sing.SingBirdSongs;
import assignment.animal.behaviour.sing.SingNothing;
import assignment.animal.behaviour.sound.*;
import assignment.animal.behaviour.swim.SwimCan;
import assignment.animal.behaviour.swim.SwimCannot;
import assignment.animal.behaviour.walk.WalkCan;
import assignment.animal.behaviour.walk.WalkCannot;


public class AnimalFactory {
    public static Animal createAnimal(String animal) {
        animal = animal.toLowerCase().trim();
        switch(animal){
            case "dog":
                return Animal.builder()
                        .name("dog")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCannot())
                        .soundMakesBehaviour(new SoundDogMakes())
                        .build();
            case "cat":
                return Animal.builder()
                        .name("cat")
                        .category(AnimalCategory.UNCLASSIFIED)
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyCannot())
                        .singBehaviour(new SingNothing())
                        .swimBehaviour(new SwimCannot())
                        .walkBehaviour(new WalkCannot())
                        .soundMakesBehaviour(new SoundCatMakes())
                        .build();
            case "duck":
                return Animal.builder()
                        .name("duck")
                        .category(AnimalCategory.BIRD)
                        .gender(Gender.FEMALE)
                        .flyBehaviour(new FlyWithWings())
                        .singBehaviour(new SingBirdSongs())
                        .swimBehaviour(new SwimCan())
                        .walkBehaviour(new WalkCan())
                        .soundMakesBehaviour(new SoundDuckMakes())
                        .build();
            case "chicken":
            case "rooster":
                return createChickenOrRooster(animal);
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
}
