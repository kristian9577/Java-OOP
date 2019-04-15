package DependencyInversion;

public class Multiplication implements Operation {

    @Override
    public int execute(int first, int second) {
        return first * second;
    }
}
