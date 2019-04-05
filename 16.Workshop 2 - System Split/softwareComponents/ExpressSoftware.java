package softwareComponents;

public class ExpressSoftware extends Software {
    private static final String TYPE="Express";
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, ExpressSoftware.TYPE, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
