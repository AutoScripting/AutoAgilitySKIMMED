package autoagilityskimmed.data;

public enum CoursesData {
    GNOME_BASIC("Gnome Basic Course", 1, true, false);

    final String courseName;
    final int courseLevelRequirement;
    final boolean courseEnabled, foodEnabled;

    private CoursesData(final String courseName, final int courseLevelRequirement,
                        final boolean courseEnabled, final boolean foodEnabled) {
        this.courseLevelRequirement = courseLevelRequirement;
        this.courseName = courseName;
        this.courseEnabled = courseEnabled;
        this.foodEnabled = foodEnabled;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseLevelRequirement() {
        return courseLevelRequirement;
    }

    public boolean isCourseEnabled() {
        return courseEnabled;
    }

    public boolean isFoodEnabled() {
        return foodEnabled;
    }

    @Override
    public String toString() {
        return "Level: " + getCourseLevelRequirement() + "  -  " + getCourseName();
    }
}
