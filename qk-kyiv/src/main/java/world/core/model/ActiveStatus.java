package world.core.model;

import java.util.Arrays;
import java.util.Optional;

public enum ActiveStatus {
    A("Active"),
    I("Inactive"),
    D("Discarded");

    private String dscr;

    ActiveStatus(String dscr) {
        this.dscr = dscr;
    }

    public String getDscr() {
        return this.dscr;
    }

    public static Optional<ActiveStatus> fromCode(String dscr) {
        return Arrays.stream(values())
          .filter(item -> item.dscr.equalsIgnoreCase(dscr))
          .findFirst();
    }
}
