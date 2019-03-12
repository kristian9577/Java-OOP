package Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
        super.setGender("Male");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
