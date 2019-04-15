package DependencyInversion;

public class Substraction implements Operation {
    @Override
    public int execute(int first, int second) {
        return first-second;
    }
}
