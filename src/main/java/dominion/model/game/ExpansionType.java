package dominion.model.game;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExpansionType {
    BASE("Base"),
    INTRIGUE("Intrigue"),
    SEASIDE("Seaside"),
    ALCHEMY("Alchemy"),
    PROSPERITY("Prosperity"),
    CORNUCOPIA("Cornucopia"),
    HINTERLANDS("Hinterlands"),
    DARK_AGES("Dark Ages"),
    GUILDS("Guilds"),
    PROMO("Promo");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private ExpansionType(String displayName) {
        this.displayName = displayName;
    }
}
