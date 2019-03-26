package interfaces;

import enums.ReportLevel;

public interface Appender {
public void append(String time, String message, ReportLevel reportLevel);
}
