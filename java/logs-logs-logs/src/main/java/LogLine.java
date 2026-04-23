public class LogLine {
    private final LogLevel logLevel;
    private final String message;

    public LogLine(String logLine) {
        String abbrev = logLine.substring(1, 4);
        this.message = logLine.substring(7);
        this.logLevel = switch (abbrev) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getOutputForShortLog() {
        return logLevel.getCode() + ":" + message;
    }
}
