package EventImplementation;

public class EventHandlerSender implements NameChangeListener {
    @Override
    public void handleOnNameChanged(Event event) {
        System.out.println(String.format("Sending on the web...",event.getChangeName()));
    }
}
