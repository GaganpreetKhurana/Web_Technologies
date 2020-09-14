import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;


public class crawler {

    private static final Stack<String> linkStack = new Stack<>();
    private static final HashSet<String> visitedLinks = new HashSet<>();
    private static FileWriter textFile;
    private static FileWriter linksFile;


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
            if (!newURL.contains("#") && !visitedLinks.contains(newURL) && newURL.contains("pec")) {
                linkStack.add(newURL);
                visitedLinks.add(newURL);
                try {
                    String row = link.text() + "," + newURL + "\n";
                    linksFile.write(row);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error writing to links.csv!");
                }
            }

        }
    }

    public static void extractText(final Document page) {
        Elements paragraphTags = page.getElementsByTag("p");
        for (Element paragraph : paragraphTags) {
            if (paragraph.text().length() > 0) {
                try {
                    String row = "<p>," + paragraph.text() + "\n";
                    textFile.write(row);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error writing to text.csv!");
                }
            }
        }
    }

    public static void crawl(String url) throws IOException {
        System.out.println(url);

        Document page = Jsoup.connect(url).get();
        extractText(page);
        extractLinks(page);


    }

    public static void main(String[] args) {
        try {
            linksFile = new FileWriter("Assignment_3\\links.csv");
            textFile = new FileWriter("Assignment_3\\text.csv");
            String row = "Tag ,Text\n";
            textFile.write(row);
            row = "Link Text,URL\n";
            linksFile.write(row);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable To Create File(s)!");
            System.exit(1);
        }
        System.out.print("Input URL: ");
        Scanner input = new Scanner(System.in);
        String url = "https://pec.ac.in";//input.nextLine();
        input.close();
        if (!isValid(url)) {
            System.out.println("INVALID URL!");
            return;
        }
        linkStack.add(url);
        visitedLinks.add(url);
        int count = 4;

        while (!linkStack.isEmpty() && count > 0) {
            try {
                count--;
                crawl(linkStack.pop());
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Unable to parse " + url);
            }
        }
        try {
            textFile.close();
            linksFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to close files!");
        }

    }
}