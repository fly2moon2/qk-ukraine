package app.config.model;

import java.util.Arrays;
import java.util.Optional;

public enum PreferenceScope {
    SYS("System"),
    ORG("Organisation"),
    PEERS("Peers"),
    USR("User");

    private String dscr;

    PreferenceScope(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<PreferenceScope> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
  }
  