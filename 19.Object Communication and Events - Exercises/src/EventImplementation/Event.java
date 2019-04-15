package EventImplementation;

import java.util.EventObject;

public class Event extends EventObject {

    private String changeName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source, String changeName) {
        super(source);
        this.changeName = changeName;
    }

    public String getChangeName() {
        return changeName;
    }
}
