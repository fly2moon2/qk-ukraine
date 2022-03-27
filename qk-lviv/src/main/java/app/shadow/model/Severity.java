package app.shadow.model;

import java.util.Arrays;
import java.util.Optional;
// make reference to syslog severity level
public enum Severity {
    EMERG("Emergency"),
    ALERT("Alert"),
    CRIT("Critical"),
    ERR("Error"),
    WARN("Warning"),
    NOTIC("Notice"),    
    INFO("Informational"),
    DEBUG("Debug");

    private String dscr;

   Severity(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<Severity> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
  }
  