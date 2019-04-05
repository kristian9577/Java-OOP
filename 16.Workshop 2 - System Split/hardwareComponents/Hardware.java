package hardwareComponents;

import softwareComponents.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Hardware {
    private String name;
    private String type;
    private int maxCapacity;
    private int maxMemory;
    private Map<String, Software> softwareComponents;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, String type, int maxCapacity, int maxMemory) {
        this.name = name;
        this.type = type;
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.softwareComponents = new LinkedHashMap<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public String getName() {
        return name;
    }

    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    private boolean hasFreeCapacity(int capacity) {
        return (this.maxCapacity - (this.usedCapacity + capacity)) >= 0;
    }

    private boolean hasFreeMemory(int memory) {
        return (this.maxMemory - (this.usedMemory + memory)) >= 0;
    }

    public void addSoftware(Software software) {
        if (this.hasFreeCapacity(software.getCapacityConsumption())
                && this.hasFreeMemory(software.getMemoryConsumption())) {
            this.softwareComponents.putIfAbsent(software.getName(), software);
            this.usedCapacity += software.getCapacityConsumption();
            this.usedMemory += software.getMemoryConsumption();
        }
    }

    public void releaseSoftware(String softwareName) {
        if (this.softwareComponents.containsKey(softwareName)) {
            Software software = this.softwareComponents.remove(softwareName);
            this.usedCapacity -= software.getCapacityConsumption();
            this.usedMemory -= software.getMemoryConsumption();
        }
    }

    public int getSoftwareComponentsCount() {
        return this.softwareComponents.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String separator = java.lang.System.lineSeparator();

        int expressCount = (int) this.softwareComponents.keySet()
                .stream()
                .filter(e -> this.softwareComponents.get(e).getType().equals("Express"))
                .count();
        int lightCount = this.softwareComponents.size() - expressCount;


        sb.append("Hardware Component - ")
                .append(this.getName())
                .append(separator)
                .append("Express Software Components - ")
                .append(expressCount)
                .append(separator)
                .append("Light Software Components - ")
                .append(lightCount)
                .append(separator)
                .append("Memory Usage: ")
                .append(this.usedMemory)
                .append(" / ")
                .append(this.maxMemory)
                .append(separator)
                .append("Capacity Usage: ")
                .append(this.usedCapacity)
                .append(" / ")
                .append(this.maxCapacity)
                .append(separator)
                .append("Type: ")
                .append(this.getType())
                .append(separator)
                .append("Software Components: ");
        String[] values = this.softwareComponents.values()
                .stream().map(Software::getName)
                .toArray(String[]::new);
        if (values.length == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", values));
        }
        return sb.toString();
    }
}
