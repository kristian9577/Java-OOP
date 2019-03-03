package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class studentSystem {
    private Map<String, Student> repository;

    public studentSystem() {
        this.repository = new HashMap<>();
    }

    public void executeCommand(String[] args) {
        if (args[0].equals("Create")) {
            createStudent(args);
        } else if (args[0].equals("Show")) {
            showStudent(args[1]);
        }
    }

    private void showStudent(String name) {
        if (!repository.containsKey(name)) {
            return;
        }
        Student student = repository.get(name);

        System.out.println(student.toString());
    }


    private void createStudent(String[] args) {
        String name = args[1];
        if (repository.containsKey(name)) {
            return;
        }
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        Student student = new Student(name, age, grade);
        repository.put(name, student);
    }

}
