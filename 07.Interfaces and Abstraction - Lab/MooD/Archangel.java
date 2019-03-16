package MooD;

public class Archangel extends Character<String> {
    private static final String CHARACTER_TYPE = "Archangel";

    public Archangel(String userName, int level, Integer specialPoints) {
        super(userName, CHARACTER_TYPE, level, specialPoints);

    }

    @Override
    public String getHashedPassword() {
        StringBuilder sb = new StringBuilder(this.getUsername());
        return sb.append("\"")
                .reverse()
                .append("\"")
                .append(this.getUsername().length() * 21)
                .toString();
    }

    @Override
    String getSpecialPointsByLevel() {
        return String.format("%d", this.getSpecialPoints().intValue() * this.getLevel());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}