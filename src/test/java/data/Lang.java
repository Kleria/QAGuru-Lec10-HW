package data;


public enum Lang {
    ENGLISH("Welcome to Wikipedia"),
    ITALIANO("Benvenuti su Wikipedia");

    public final String description;

    Lang(String description) {
        this.description = description;
    }
}
