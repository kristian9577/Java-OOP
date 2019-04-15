package KingsGambit;

import KingsGambit.interfaces.Defender;

public class Footmen extends Unit implements Defender {
    public Footmen(String name) {
        super(name);
    }

    @Override
    public String respondToAttack() {
        return String.format("Footman %s is panicking!", this.getName());
    }
}
