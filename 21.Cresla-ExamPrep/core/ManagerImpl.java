package cresla.core;

import cresla.interfaces.*;
import cresla.interfaces.Module;
import cresla.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private static int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImpl() {
        ManagerImpl.id = 1;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        //•	Reactor {reactorType} {additionalParameter} {moduleCapacity}
        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int capacity = Integer.parseInt(arguments.get(2));

        Reactor reactor = null;
        if (type.equalsIgnoreCase("Cryo")) {
            reactor = new CryoReactor(id, capacity, additionalParam);
        } else {
            reactor = new HeatReactor(id, capacity, additionalParam);
        }

        this.reactors.putIfAbsent(id, reactor);
        return String.format("Created %s Reactor - %d", type, id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        //•	Module {reactorId} {type} {additionalParameter}
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));

        Module module = null;

        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(id, additionalParam);
                break;
            case "HeatProcessor":
                module = new HeatProcessor(id, additionalParam);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(id, additionalParam);
                break;
        }
        if (type.equals("CryogenRod")) {
            this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
        } else {
            this.reactors.get(reactorId).addAbsorbingModule((AbsorbingModule) module);
        }

        this.modules.putIfAbsent(id,module);

        return String.format("Added %s - %d to Reactor - %d", type, id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int objectId = Integer.parseInt(arguments.get(0));

        String output = "";
        if (this.reactors.containsKey(objectId)) {
            output = this.reactors.get(objectId).toString();
        } else if (this.modules.containsKey(objectId)) {
            output = this.modules.get(objectId).toString();
        }
        return output;
    }

    @Override
    public String exitCommand(List<String> arguments) {
//        Cryo Reactors: {cryoReactorsCount}
//        Heat Reactors: {heatReactorsCount}
//        Energy Modules: {energyModulesCount}
//        Absorbing Modules: {absorbingModulesCount}
//        Total Energy Output: {totalEnergyOutput}
//        Total Heat Absorbing: {totalHeatAbsorbing}
        StringBuilder sb = new StringBuilder();

        int cryoCount = 0;
        int heatReactor = 0;
        int energyModulesCount = 0;
        int absorbingModulesCount = 0;
        long totalEnergyOutput = 0;
        long totalHeatAbsorbing = 0;

        for (Map.Entry<Integer, Reactor> entry : reactors.entrySet()) {
            if (entry.getValue().getClass().getSimpleName().contains("Cryo")) {
                cryoCount++;
                totalEnergyOutput += entry.getValue().getTotalEnergyOutput();
            } else {
                heatReactor++;
                totalHeatAbsorbing += entry.getValue().getTotalHeatAbsorbing();
            }
        }
        for (Map.Entry<Integer, Module> entry : modules.entrySet()) {
            if (entry.getValue().getClass().getSuperclass().getSimpleName().contains("Energy")) {
                energyModulesCount++;
            } else {
                absorbingModulesCount++;
            }
        }
        sb.append("Cryo Reactors: ").append(cryoCount).append(System.lineSeparator());
        sb.append("Heat Reactors:  ").append(heatReactor).append(System.lineSeparator());
        sb.append("Energy Modules: ").append(energyModulesCount).append(System.lineSeparator());
        sb.append("Absorbing Modules: ").append(absorbingModulesCount).append(System.lineSeparator());
        sb.append("Total Energy Output: ").append(totalEnergyOutput).append(System.lineSeparator());
        sb.append("Total Heat Absorbing: ").append(totalHeatAbsorbing);

        return sb.toString();
    }

}
