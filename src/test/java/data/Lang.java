package data;


public enum Lang {
    English("Welcome to Wikipedia"),
    Italiano("Benvenuti su Wikipedia");

    public final String description;

    Lang(String description) {
        this.description = description;
    }
}
