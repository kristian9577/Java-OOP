package EventImplementation;

public class EventHandlerPrinter implements NameChangeListener {
    @Override
    public void handleOnNameChanged(Event event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangeName()));
    }
}
