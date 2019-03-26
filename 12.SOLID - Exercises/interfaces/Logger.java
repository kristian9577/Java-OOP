package interfaces;

public interface Logger {
    public void logInfo(String time, String message);

    public void logWarning(String time, String message);

    public void logError(String time, String message);

    public void logCritical(String time, String message);

    public void logFatal(String time, String message);
}
