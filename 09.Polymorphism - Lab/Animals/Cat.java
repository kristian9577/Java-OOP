package Animals;

public class Cat extends Animal {
    public Cat(String name, String favoriteFood) {
        super(name,favoriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW",super.explainSelf());
    }
}
