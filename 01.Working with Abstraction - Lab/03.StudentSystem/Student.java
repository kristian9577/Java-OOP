package StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        String view = String.format("%s is %s years old.", this.getName(), this.getAge());


        return view + this.getGradeString();
    }

    private String getGradeString() {
        String result = " Very nice person.";
        if (this.getGrade() >= 5.00) {
            result = " Excellent student.";
        } else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50) {
            result = " Average student.";
        }
        return result;
    }
}
