package app.core;

import java.util.Arrays;
import java.util.Optional;

public enum ModelEntityFamily {
    PREF("Preference"),
    LANG("Language");

    private String dscr;

   ModelEntityFamily(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<ModelEntityFamily> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
  }
  