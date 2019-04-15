package EventImplementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();

        NameChangeListener firstObserver = new EventHandlerPrinter();
        NameChangeListener secondObserver = new EventHandlerSender();

        dispatcher.addObserver(firstObserver);
       // dispatcher.addObserver(secondObserver);

        String input = reader.readLine();

        while (!input.equals("End")) {
        dispatcher.setName(input);

            input = reader.readLine();
        }
    }
}
