import java.util.Scanner;

class Solution {
    private static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
    private static int N = 0;
    private static int M = 0;

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

    private static int helper(String[] crops, int x, int y, char c, int changes) {
        if (crops[x].charAt(y) != c) {
            changes++;
        }
        String new_string = crops[x].substring(0, y) + c + crops[x].substring(y + 1);
        String old_string = crops[x];
        crops[x] = new_string;
        x += 1;
        if (isInValid(x, y)) {
            x -= 1;
            y += 1;
            if (isInValid(x, y)) {
                crops[x] = old_string;
                return changes;
            }
        }
        int temp_change = 0, min_change = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if ((!isInValid(x + 1, y) && alphabets.charAt(i) == crops[x + 1].charAt(y))
                    || (!isInValid(x - 1, y) && alphabets.charAt(i) == crops[x - 1].charAt(y))
                    || (!isInValid(x, y + 1) && alphabets.charAt(i) == crops[x].charAt(y + 1))
                    || (!isInValid(x, y - 1) && alphabets.charAt(i) == crops[x].charAt(y - 1))) {
                continue;
            }
            temp_change = helper(crops, x, y, alphabets.charAt(i), changes);
            if (temp_change != Integer.MAX_VALUE) {
                min_change = Math.min(temp_change, min_change);
            }
        }
        crops[x] = old_string;
        return min_change;
    }

    public static int replant(String[] crops) {
        // Write your code here
        // Return the number of replanted crops
        int min_changes = Integer.MAX_VALUE;
        int changes = 0;
        for (int i = 0; i < 26; i++) {
            changes = helper(crops, 0, 0, alphabets.charAt(i), changes);
            min_changes = Math.min(min_changes, changes);
            changes = 0;
        }

        return min_changes;

    }
}