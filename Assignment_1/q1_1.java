import java.util.HashMap;
import java.util.Scanner;

public class q1_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter String: ");
        String string = input.nextLine(); // Main string
        System.out.print("Enter SubString: ");
        String subString = input.nextLine(); // substring
        input.close();
        if (string.length() < subString.length()) {
            // main string length < substring length
            System.out.println(0);
        } else {
            HashMap<Character, Integer> mapSubString = new HashMap<Character, Integer>();
            for (Character c : subString.toCharArray()) {
                // hashmap of substring characters and their frequency
                mapSubString.put(c, 1 + mapSubString.getOrDefault(c, 0));
            }
            HashMap<Character, Integer> mapTemp = new HashMap<Character, Integer>(); // hashmap for current main string substring characters and their characters
            // start :- main string substring start index,count :- occurrences
            int start = 0, count = 0;
            for (int i = 0; i < string.length(); i++) {
                if (i >= subString.length()) {
                    // main string substring length > substring length
                    // remove first character of previous main string substring
                    mapTemp.put(string.charAt(start), mapTemp.get(string.charAt(start)) - 1);
                    if (mapTemp.get(string.charAt(start)) == 0) {
                        mapTemp.remove(string.charAt(start));
                    }
                    start++;
                }
                // add current main string character
                mapTemp.put(string.charAt(i), 1 + mapTemp.getOrDefault(string.charAt(i), 0));
                if (mapTemp.equals(mapSubString)) {
                    // check if current main string substring = substring
                    count++;
                }
            }
            System.out.println('\n' + "Number of times: " + count);

        }

    }
}