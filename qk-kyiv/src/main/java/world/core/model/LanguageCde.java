package world.core.model;

import java.util.Arrays;
import java.util.Optional;

public enum LanguageCde {
    EN("ENGLISH"),
    CN("CHINESE"),
    JP("JAPANESE"),
    KR("KOREAN"),
    RU("RUSSIAN");


    private String dscr;

    LanguageCde(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<LanguageCde> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
  }
  