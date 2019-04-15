package EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> observers;

    public Dispatcher() {
        this.name = "";
        this.observers = new ArrayList<>();
    }

    public void addObserver(NameChangeListener observer) {
        this.observers.add(observer);
    }

    public void removeObserver(NameChangeListener observer) {
        this.observers.remove(observer);
    }

    public void setName(String name) {
        this.name = name;
        this.fireEvent();
    }

    private void fireEvent() {
        Event event = new Event(this, this.name);
        for (NameChangeListener observer : observers) {
            observer.handleOnNameChanged(event);
        }
    }
}
