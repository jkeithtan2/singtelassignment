package assignment.animal.factory;

import assignment.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactory implements AbstractAnimalFactory{


    @Override
    public Animal create(String animalType) {
        AbstractAnimalFactory birdFactory = new BirdFactory();
        AbstractAnimalFactory fishFactory = new FishFactory();
        AbstractAnimalFactory insectFactory = new InsectFactory();
        AbstractAnimalFactory mammalFactory = new MammalFactory();

        List<AbstractAnimalFactory> abstractAnimalFactoryList = new ArrayList<>();
        abstractAnimalFactoryList.add(birdFactory);
        abstractAnimalFactoryList.add(fishFactory);
        abstractAnimalFactoryList.add(insectFactory);
        abstractAnimalFactoryList.add(mammalFactory);

        Animal animal;

        for (AbstractAnimalFactory aaf : abstractAnimalFactoryList) {
            animal = aaf.create(animalType);
            if (animal != null) {
                return animal;
            }
        }
        return null;
    }
}
