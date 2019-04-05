import core.Engine;
import core.System;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System system = new System();
        Engine engine = new Engine(system);

        engine.run();
        java.lang.System.out.println(system.toString());
    }
}
