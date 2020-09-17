import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class crawler {
    private static final HashSet<String> visitedLinks = new HashSet<>();
    private static final HashMap<Integer, List<String>> table = new HashMap<>();
    private static final Queue<Link> linkQueue = new LinkedList<>();
    private static int maxDepth;
    private static FileWriter textFile;
    private static FileWriter linksFile;
    private static FileWriter nonHtmlLinksFile;
    private static String urlContains = "";
    private static int depth = 0;

    public static boolean isValid(String url) {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }
        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }

    public static void extractLinks(final Document page) {
        Elements links = page.getElementsByTag("a");
        for (Element link : links) {
            String newURL = link.attr("abs:href");
            if (!newURL.contains("#") && !visitedLinks.contains(newURL) && newURL.contains(urlContains)) {
                Link temp = new Link();
                temp.url = newURL;
                temp.text = link.text();
                linkQueue.add(temp);
            }
        }
    }

    public static void extractText(final Document page) {

        Elements paragraphTags = page.getElementsByTag("p");
        for (Element paragraph : paragraphTags) {
            if (paragraph.text().length() > 0) {
                try {
//                    System.out.println(paragraph.html());
                    String row = "<p>,\"" + paragraph.text() + "\"\n";
                    textFile.write(row);
                } catch (IOException e) {
                    System.out.println("Error writing to text.csv!");
                }
            }
        }
    }

    public static void crawl(String url, String text) {
        if (visitedLinks.contains(url)) {
            return;
        }
        System.out.println("Parsing: " + url + " Depth: " + depth);
        visitedLinks.add(url);
        if (!table.containsKey(depth)) {
            List<String> temp = new ArrayList<>();
            table.put(depth, temp);
        }
        table.get(depth).add(url);
        try {
            if (depth <= maxDepth) {
                Document page = Jsoup.connect(url).get();
                if (url.contains("faculty")) {
                    extractText(page);
                }
                extractLinks(page);
            }
            if (url.contains("faculty")) {
                try {
                    String row = text + "," + url + "\n";
                    linksFile.write(row);
                } catch (IOException e) {
                    System.out.println("Error writing to links.csv!");
                }
            }

        } catch (UnsupportedMimeTypeException type) {
            if (url.contains("faculty")) {
                try {
                    nonHtmlLinksFile.write(text + "," + url + "\n");
                } catch (IOException e) {
                    System.out.println("Error writing to nonHtmlLinks.csv!");
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to parse " + url);
        }

    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        try {
            linksFile = new FileWriter("Assignment_3\\links.csv");
            textFile = new FileWriter("Assignment_3\\text.csv");
            nonHtmlLinksFile = new FileWriter("Assignment_3\\nonHtmlLinks.csv");

            String row = "Tag ,Text\n";
            textFile.write(row);

            row = "Link Text,URL\n";
            linksFile.write(row);

            row = "Link Text,URL\n";
            nonHtmlLinksFile.write(row);

        } catch (IOException e) {
            System.out.println("Unable To Create File(s)!");
            System.exit(1);
        }
        String url = "";
        try {
            System.out.print("Input URL: ");
            Scanner input = new Scanner(System.in);
            url = "https://pec.ac.in";//input.nextLine();
            System.out.print("Enter String: ");
            urlContains = "pec.ac.in";//input.nextLine();
            System.out.print("Enter MAX Depth(BFS): ");
            maxDepth = 1;
//        input.nextInt();
//        input.nextLine();
            input.close();
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            System.exit(1);
        }

        if (!isValid(url)) {
            System.out.println("INVALID URL!");
            return;
        }
        Link temp = new Link();
        temp.url = url;
        temp.text = "---ROOT---";
        linkQueue.add(temp);
        linkQueue.add(null);
        while (!linkQueue.isEmpty()) {
            temp = linkQueue.remove();
            if (temp == null) {
                depth++;
                if (!linkQueue.isEmpty()) {
                    linkQueue.add(null);
                }
            } else {
                crawl(temp.url, temp.text);
            }
        }

        try {

            textFile.close();
            linksFile.close();
            nonHtmlLinksFile.close();

        } catch (IOException e) {
            System.out.println("Unable to close files!");
        }

        long endTime = System.nanoTime();
        double timeElapsed = (endTime - startTime) / 1000000000.0;
        System.out.println("Time Elapsed: " + timeElapsed / 60.0);

    }

    private static class Link {
        public String url = "";
        public String text = "";
    }
}