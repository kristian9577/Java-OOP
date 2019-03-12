package Animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        super.setGender("Female");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
