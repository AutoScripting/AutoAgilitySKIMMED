package autoagilityskimmed.data;

public enum CoursesData {
    GNOME_BASIC("Gnome Basic Course", 1, true, false);

    final String name;
    final int levelRequirement;
    final boolean courseEnabled, foodEnabled;

    private CoursesData(final String name, final int levelRequirement,
                        final boolean courseEnabled, final boolean foodEnabled) {
        this.levelRequirement = levelRequirement;
        this.name = name;
        this.courseEnabled = courseEnabled;
        this.foodEnabled = foodEnabled;
    }

    public String getName() {
        return name;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public boolean isCourseEnabled() {
        return courseEnabled;
    }

    public boolean isFoodEnabled() {
        return foodEnabled;
    }

    @Override
    public String toString() {
        return "Level: " + getLevelRequirement() + "  -  " + getName();
    }
}
