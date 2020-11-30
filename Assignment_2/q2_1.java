import java.util.Scanner;

public class q2_1 {
    private static String lexCompare(String a, String b) {
        int i = 0;
        int l = a.length() < b.length() ? a.length() : b.length(); // minimum Length
        while (i < l) {
            if (a.charAt(i) < b.charAt(i)) {
                return "SMALLER";
            } else if (a.charAt(i) > b.charAt(i)) {
                return "GREATER";
            }
            i++;
        }
        if (a.length() == b.length()) {
            return "Equal";
        }

        // Smaller string is a prefix of Longer String
        if (a.length() < b.length()) {
            return "SMALLER";
        }
        return "GREATER";
    }

    public static void main(String[] args) {
        System.out.println("NOTE: If smaller string is a prefix of longer string then prefix is smaller.\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First String: ");
        String first = input.nextLine(); // First String
        System.out.print("Enter Second String: ");
        String second = input.nextLine(); // Second String
        System.out.println("Output: First string is " + lexCompare(first.toLowerCase(), second.toLowerCase())
                + " to/than Second string.");
        input.close();
    }
}