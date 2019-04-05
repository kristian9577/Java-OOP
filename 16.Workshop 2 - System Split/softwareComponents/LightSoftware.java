package softwareComponents;

public class LightSoftware extends Software {
    private static final String TYPE="Light";
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, LightSoftware.TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        super.setCapacityConsumption(capacityConsumption + capacityConsumption / 2);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption - memoryConsumption / 2);
    }
}
