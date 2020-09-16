import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class crawler {

    private static final HashSet<String> visitedLinks = new HashSet<>();
    private static final Queue<String> linkQueue = new LinkedList<>();
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

                visitedLinks.add(newURL);
//                try {
//                    Jsoup.connect(newURL).get();
//                } catch (UnsupportedMimeTypeException type) {
//                    if (newURL.contains("faculty")) {
//                        try {
//                            nonHtmlLinksFile.write(link.text() + "," + newURL + "\n");
//                        } catch (IOException e) {
//                            System.out.println("Error writing to nonHtmlLinks.csv!");
//                        }
//                    }
//                    return;
//                } catch (IOException ignored) {
//
//                }
                linkQueue.add(newURL);
                if (newURL.contains("faculty")) {
                    try {
                        String row = link.text() + "," + newURL + "\n";
                        linksFile.write(row);
                    } catch (IOException e) {
                        System.out.println("Error writing to links.csv!");
                    }
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
                    System.out.println("Error writing to text.csv!");
                }
            }
        }
    }

    public static void crawl(String url) {
        System.out.println(url);
        try {
            Document page = Jsoup.connect(url).get();
            if (url.contains("faculty")) {
                extractText(page);
            }
            extractLinks(page);
        } catch (UnsupportedMimeTypeException type) {
            if (url.contains("faculty")) {
                try {
                    nonHtmlLinksFile.write("----," + url + "\n");
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
        System.out.print("Input URL: ");
        Scanner input = new Scanner(System.in);
        String url = "https://pec.ac.in";//input.nextLine();
        System.out.print("Enter String: ");
        urlContains = "pec.ac.in";//input.nextLine();
        input.close();
        if (!isValid(url)) {
            System.out.println("INVALID URL!");
            return;
        }
        visitedLinks.add(url);
        linkQueue.add(url);
        linkQueue.add(null);
        while (!linkQueue.isEmpty() && depth < 5) {
            url = linkQueue.remove();
            if (url == null) {
                depth++;
                if (linkQueue.size() > 1) {
                    linkQueue.add(null);
                }
                System.out.println("Depth: " + depth);
                continue;

            }
            System.out.print("Parsing: ");
            crawl(url);

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
}