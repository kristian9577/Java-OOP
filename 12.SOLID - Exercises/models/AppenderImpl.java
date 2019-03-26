package models;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    public static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesCOunt;


    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = AppenderImpl.REPORT_LEVEL_DEFAULT;
        this.messagesCOunt = 0;
    }

    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.reportLevel = reportLevel;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }


    @Override
    public abstract void append(String time, String message, ReportLevel reportLevel);

    protected boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }
}
