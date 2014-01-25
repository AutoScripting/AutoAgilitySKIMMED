package autoagilityskimmed.data;

public enum FoodData {
    TUNA("Tuna", 361),
    LOBSTERS("Lobsters", 379);

    final String name;
    final int id;

    private FoodData(final String name, final int id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name;
    }
}
