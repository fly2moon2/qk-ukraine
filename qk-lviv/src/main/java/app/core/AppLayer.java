package app.core;

import java.util.Arrays;
import java.util.Optional;

public enum AppLayer {
    UI("User Interface"),
    REST("REST API"),
    GRAPHQL("GraphQL"),
    DB("Database"),
    HTTP("HTTP"),
    SFTP("SFTP");

    private String dscr;

   AppLayer(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<AppLayer> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
  }
  