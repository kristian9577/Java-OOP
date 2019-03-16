package MooD;

public abstract class Character<T> implements GameObject<T> {
    private String userName;
    private String characterType;
    private Number specialPoints;
    private int level;
    private T hashedPassword;

    public Character() {
    }

    public Character(String userName, String characterType, int level, Number specialPoints) {
        this.setUserName(userName);
        this.setCharacterType(characterType);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getCharacterType() {
        return characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return specialPoints;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setUserName(String userName) {
        this.userName = "\"" + userName + "\"";
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public void setHashedPassword(T hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    abstract String getSpecialPointsByLevel();

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n%s",
                this.getUsername(),
                this.getHashedPassword(),
                this.getCharacterType(),
                this.getSpecialPointsByLevel());
    }
}