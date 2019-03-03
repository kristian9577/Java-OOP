package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentSystem studentSystem = new studentSystem();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")) {
                break;
            }
            studentSystem.executeCommand(input);
        }
    }
}
