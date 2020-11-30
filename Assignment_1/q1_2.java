import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Paragraph: ");
        String paragraph = input.nextLine(); // paragraph
        System.out.print("Enter strings: ");
        String[] wordsToBeReplaced = input.nextLine().split(" "); // words to be replaced
        input.close();
        for (String word : wordsToBeReplaced) {
            Pattern p = Pattern.compile("\\b" + word + "\\b"); // pattern of word to find
            Matcher m = p.matcher(paragraph); // find if pattern matches
            if (m.find()) {
                StringBuilder newString = new StringBuilder(); // create new string
                newString.append(word.charAt(0));
                newString.append("*".repeat(word.length() - 1));
                paragraph = m.replaceAll(newString.toString()); // replace all the word
            }
        }
        System.out.println("Updated Paragraph: " + paragraph);
    }
}