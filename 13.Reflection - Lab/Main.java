import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("This class type: " + Reflection.class);
        System.out.println("Super class type: " + Reflection.class.getSuperclass());
        Class[] interfaces = Reflection.class.getInterfaces();

        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("Interface: " + interfaces[i]);
        }

        Reflection reflection = (Reflection) Class.forName(Reflection.class.getName()).getConstructor().newInstance();

        System.out.println(reflection);
    }
}
