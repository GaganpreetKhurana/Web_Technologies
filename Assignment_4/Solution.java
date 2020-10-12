import java.util.Scanner;

class Solution {
    private static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private static int N = 0;
    private static int M = 0;
    private static int minimum_changes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        String[] crops = new String[n];
        for (int i = 0; i < n; i++) {
            crops[i] = in.nextLine().trim();
        }
        N = n;
        M = m;
        System.out.println(replant(crops));
    }

    private static boolean isInValid(int x, int y) {
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    private static void replace(String[] crops, int x, int y, int replacements) {
        int character = -1;
        for (int i = 0; i < 26; i++) {
            if ((!isInValid(x - 1, y) && crops[x - 1].charAt(y) == alphabets.charAt(i))
                    || (!isInValid(x + 1, y) && crops[x + 1].charAt(y) == alphabets.charAt(i))
                    || (!isInValid(x, y - 1) && crops[x].charAt(y - 1) == alphabets.charAt(i))
                    || (!isInValid(x, y + 1) && crops[x].charAt(y + 1) == alphabets.charAt(i))
            ) {
                continue;
            }
            character = i;
            break;
        }
        if (character == -1) {
            return;
        }
        String new_string = crops[x].substring(0, y) + alphabets.charAt(character) + crops[x].substring(y + 1);
        String old_string = crops[x];
        crops[x] = new_string;
        helper(crops, x, y + 1, replacements + 1);
        crops[x] = old_string;
    }

    private static void helper(String[] crops, int x, int y, int replacements) {

        if (isInValid(x, y)) {
            y = 0;
            x += 1;
            if (isInValid(x, y)) {
                minimum_changes = Math.min(replacements, minimum_changes);
                return;
            }
        }
        if ((!isInValid(x - 1, y) && crops[x].charAt(y) == crops[x - 1].charAt(y)) || (!isInValid(x, y - 1) && crops[x].charAt(y) == crops[x].charAt(y - 1))) {
            replace(crops, x, y, replacements);
        } else if ((!isInValid(x + 1, y) && crops[x].charAt(y) == crops[x + 1].charAt(y)) || (!isInValid(x, y + 1) && crops[x].charAt(y) == crops[x].charAt(y + 1))) {
            helper(crops, x, y + 1, replacements);
            replace(crops, x, y, replacements);
        } else {
            helper(crops, x, y + 1, replacements);
        }
    }

    public static int replant(String[] crops) {
        // Write your code here
        // Return the number of replanted crops
        helper(crops, 0, 0, 0);

        return minimum_changes;

    }
}