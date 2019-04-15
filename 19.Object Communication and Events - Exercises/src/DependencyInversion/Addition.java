package DependencyInversion;

public class Addition implements Operation {
    @Override
    public int execute(int first, int second) {
        return first + second;
    }
}
