import java.util.ArrayList;
import java.time.Year;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();
        int currentYear = Year.now().getValue();

        try {
            items.add(new VideoLecture("Java Inheritance", 2024, 45, "4K"));
            items.add(new VideoLecture("Legacy Systems", 2010, 90, "HD"));
            items.add(new PodcastEpisode("Tech Weekly", 2025, 30, "Alice"));
            items.add(new PodcastEpisode("History of Code", 2022, 60, "Bob"));

            for (ContentItem item : items) {
                System.out.print(item.toString());
                System.out.printf(" | licenseCost=%.2f%n", item.getLicenseCost(currentYear));

                if (item instanceof Downloadable) {
                    Downloadable downlodableItem = (Downloadable) item;
                    downlodableItem.download();
                    System.out.println("Max downloads per day: " + downlodableItem.getMaxDownloadsPerDay());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}