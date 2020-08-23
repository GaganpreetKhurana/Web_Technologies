import java.util.Scanner;

public class q1 {
    private static String lexCompare(String a, String b) {
        int i = 0;
        int l = a.length() < b.length() ? a.length() : b.length();
        while (i < l) {
            if (a.charAt(i) < b.charAt(i)) {
                return "Smaller";
            } else if (a.charAt(i) > b.charAt(i)) {
                return "Greater";
            }
            i++;
        }
        if (a.length() == b.length()) {
            return "Equal";
        }
        if (a.length() > b.length()) {
            return "Smaller";
        }
        return "Greater";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First String: ");
        String first = input.nextLine();
        System.out.print("Enter Second String: ");
        String second = input.nextLine();
        System.out.println("Output: " + lexCompare(first.toLowerCase(), second.toLowerCase()));
        input.close();
    }
}