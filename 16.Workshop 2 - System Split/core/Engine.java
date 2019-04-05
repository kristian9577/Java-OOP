package core;

import hardwareComponents.HeavyHardware;
import hardwareComponents.PowerHardware;
import softwareComponents.ExpressSoftware;
import softwareComponents.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private System system;

    public Engine(System system) {
        this.system = system;
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(java.lang.System.in));
        String input = reader.readLine();

        while (!input.equalsIgnoreCase("System Split")) {
            String command = input.substring(0, input.indexOf("("));
            String[] cmdArgs = input
                    .substring(input.indexOf("(") + 1, input.length() - 1)
                    .split(", ");

            switch (command) {
                case "RegisterPowerHardware":
                    this.system.addHardware(new PowerHardware(cmdArgs[0],
                            Integer.parseInt(cmdArgs[1]),
                            Integer.parseInt(cmdArgs[2])));
                    break;
                case "RegisterHeavyHardware":
                    this.system.addHardware(new HeavyHardware(cmdArgs[0],
                            Integer.parseInt(cmdArgs[1]),
                            Integer.parseInt(cmdArgs[2])));
                    break;
                case "RegisterExpressSoftware":
                    this.system.addSoftwareComponent(cmdArgs[0],
                            new ExpressSoftware(cmdArgs[1],
                                    Integer.parseInt(cmdArgs[2]),
                                    Integer.parseInt(cmdArgs[3])));
                    break;
                case "RegisterLightSoftware":
                    this.system.addSoftwareComponent(cmdArgs[0],
                            new LightSoftware(cmdArgs[1],
                                    Integer.parseInt(cmdArgs[2]),
                                    Integer.parseInt(cmdArgs[3])));
                    break;
                case "ReleaseSoftwareComponent":
                    this.system.releaseSoftwareComponent(cmdArgs[0],cmdArgs[1]);
                    break;
                case "Analyze":
                    java.lang.System.out.println(this.system.analyze());
                    break;
            }

            input = reader.readLine();
        }
    }
}
