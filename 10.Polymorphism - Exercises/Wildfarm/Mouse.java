package Wildfarm;

public class Mouse extends Mammal {
    protected Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
