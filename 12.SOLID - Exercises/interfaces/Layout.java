package interfaces;

import enums.ReportLevel;

public interface Layout {
    public String format(String time, String message, ReportLevel reportLevel);
}
