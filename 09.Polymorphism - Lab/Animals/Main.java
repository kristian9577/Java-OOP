package Animals;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Pesho","Whiskas");
        Animal dog = new Dog("Gosho","Meat");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
