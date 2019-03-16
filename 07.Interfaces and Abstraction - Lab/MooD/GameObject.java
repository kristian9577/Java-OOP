package MooD;

public interface GameObject<T> {
    String getUsername();
    String getCharacterType();
    Number getSpecialPoints();
    int getLevel();
    T getHashedPassword();

    void setHashedPassword(T password);
}
