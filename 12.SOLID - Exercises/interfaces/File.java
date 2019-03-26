package interfaces;

public interface File {
    public boolean write();
    public int getSize();
    public void append(String text);
}
