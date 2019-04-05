package hardwareComponents;

public class PowerHardware extends Hardware {

    private static final String TYPE="Power";
    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, PowerHardware.TYPE, maxCapacity, maxMemory);
    }

    @Override
    protected void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity - ((maxCapacity * 3) / 4));
    }

    @Override
    protected void setMaxMemory(int maxMemory) {
        super.setMaxMemory(maxMemory + ((maxMemory * 3) / 4));
    }
}
