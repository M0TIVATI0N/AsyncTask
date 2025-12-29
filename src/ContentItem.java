import java.time.Year;

public abstract class ContentItem {
    private int id;
    private static int idGen = 1; // [cite: 19]
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++; // Присвоение и инкремент ID [cite: 27]
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }

    // Сеттеры с валидацией [cite: 27, 69]
    public void setTitle(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is blank"); // [cite: 28]
        this.title = title;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1990 || year > currentYear) throw new IllegalArgumentException("Invalid year"); // [cite: 29]
        this.year = year;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) throw new IllegalArgumentException("Duration must be > 0"); // [cite: 29]
        this.durationMinutes = durationMinutes;
    }

    public int getAge(int currentYear) { return currentYear - year; } // [cite: 31]

    public abstract double getLicenseCost(int currentYear); // [cite: 32]

    @Override
    public String toString() { // [cite: 33]
        return "ID: " + id + ", Title: " + title + ", Year: " + year + ", Duration: " + durationMinutes + "m";
    }

    // Геттеры для использования в подклассах
    protected int getDurationMinutes() { return durationMinutes; }
    protected int getYear() { return year; }
}