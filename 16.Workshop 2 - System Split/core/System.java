package core;

import hardwareComponents.Hardware;
import softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class System {
    private Map<String, Hardware> hardwareComponents;

    public System() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardware(Hardware hardware) {
        this.hardwareComponents.putIfAbsent(hardware.getName(), hardware);
    }

    public void addSoftwareComponent(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            this.hardwareComponents.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    public String analyze() {

        String separator = java.lang.System.lineSeparator();
        StringBuilder sb = new StringBuilder("System Analysis");

        sb.append(separator);
        int softwareComponentsCount = 0;
        int memoryInUse = 0;
        int memoryTotal = 0;
        int capacityInUSe = 0;
        int capacityTotal = 0;

        for (String name : hardwareComponents.keySet()) {
            softwareComponentsCount += this.hardwareComponents.get(name).getSoftwareComponentsCount();
            memoryInUse += this.hardwareComponents.get(name).getUsedMemory();
            memoryTotal += this.hardwareComponents.get(name).getMaxMemory();
            capacityInUSe += this.hardwareComponents.get(name).getUsedCapacity();
            capacityTotal += this.hardwareComponents.get(name).getMaxCapacity();
        }

        sb.append("Hardware Components: ")
                .append(this.hardwareComponents.size())
                .append(separator);
        sb.append("Software Components: ")
                .append(softwareComponentsCount)
                .append(separator);
        sb.append("Total Operational Memory: ")
                .append(memoryInUse)
                .append(" / ")
                .append(memoryTotal)
                .append(separator);
        sb.append("Total Capacity Taken: ")
                .append(capacityInUSe)
                .append(" / ")
                .append(capacityTotal);


        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String separator = java.lang.System.lineSeparator();

        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Power"))
                .forEach(e -> {
                 sb.append(e.getValue().toString())
                            .append(separator);
                });
        this.hardwareComponents.entrySet()
                .stream()
                .filter(e -> e.getValue().getType().equals("Heavy"))
                .forEach(e -> {
                    sb.append(e.getValue().toString())
                            .append(separator);
                });
        return sb.toString();
    }
}
