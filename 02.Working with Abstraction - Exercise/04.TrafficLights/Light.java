package TrafficLights;

public class Light {
    private Signal signal;

    public Light(Signal signal) {
        this.signal = signal;
    }

    public void changeSignal() {
        switch (this.signal.name()) {
            case "RED":
                this.signal = Signal.GREEN;
                break;
            case "YELLOW":
                this.signal = Signal.RED;
                break;
            case "GREEN":
                this.signal = Signal.YELLOW;
                break;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}