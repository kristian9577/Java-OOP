package models;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    private void logAll(String time, String message, ReportLevel reportLevel) {
        for (Appender appender : this.appenders) {
            appender.append(time, message, reportLevel);
        }
    }

    @Override
    public void logInfo(String time, String message) {
        this.logAll(time, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        this.logAll(time, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String time, String message) {
        this.logAll(time, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String time, String message) {
        this.logAll(time, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        this.logAll(time, message, ReportLevel.FATAL);
    }
}
