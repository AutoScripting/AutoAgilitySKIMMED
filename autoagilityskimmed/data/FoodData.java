package autoagilityskimmed.data;

public enum FoodData {
    TUNA("Tuna", 361),
    LOBSTERS("Lobsters", 379);

    final String foodName;
    final int foodId;

    private FoodData(final String foodName, final int foodId) {
        this.foodId = foodId;
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodId() {
        return foodId;
    }

    public String toString() {
        return foodName;
    }
}
