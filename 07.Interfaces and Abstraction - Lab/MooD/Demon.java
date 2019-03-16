package MooD;

public class Demon extends Character<Integer> {
    private static final String CHARACTER_TYPE = "DEMON";

    public Demon(String userName, int level, Double specialPoints) {
        super(userName, CHARACTER_TYPE, level,specialPoints);

    }

    public Integer getHashedPassword() {
        return this.getUsername().length() * 217;
    }

    @Override
    String getSpecialPointsByLevel() {
        return String.format("%.1f",this.getSpecialPoints().doubleValue()*this.getLevel());
    }
    @Override
    public String toString() {
        return super.toString();
    }

}

