package Person;

public class Child extends  Person {

    public Child(String name, int age) {
        super(name, age);
    }

    void setAge(int age) throws IllegalArgumentException {
        if (age > 16) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }


}
