import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q3 {
    public static void sortIteration(String[] arr, int position) {
        Queue<String>[] buckets = new Queue[54];
        for (int i = 0; i < 54; i++) {
            buckets[i] = new LinkedList<String>();
        }
        for (String i : arr) {
            int index;
            if (position >= i.length()) {
                index = 0;
            } else if (i.charAt(position) == ' ') {
                index = 1;
            } else if (i.charAt(position) >= 'A' && i.charAt(position) <= 'Z') {
                index = i.charAt(position) - 'A' + 2;
            } else {
                index = i.charAt(position) - 'a' + 28;
            }
            buckets[index].add(i);
        }
        int k = 0;
        for (Queue<String> i : buckets) {
            while (!i.isEmpty()) {
                arr[k] = i.remove();
                k++;
            }
        }
    }

    private static void radixSort(String[] arr) {
        int maxStringLength = 0;
        for (String i : arr) {
            if (i.length() > maxStringLength) {
                maxStringLength = i.length();
            }
        }
        for (int i = maxStringLength; i > -1; i--) {
            sortIteration(arr, i);
        }
    }

    public static void main(String[] args) {
        System.out.println("\nAlphabet Order: \"Empty String\" \"Space\" ABCD.....XYZ abcd.....xyz\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of String: ");
        int n = input.nextInt();
        input.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter String " + (i + 1) + ": ");
            arr[i] = input.nextLine();
        }
        input.close();
        System.out.println();
        radixSort(arr);
        System.out.print("Output: ");
        for (String i : arr) {
            System.out.print('\"' + i + '\"' + " ");
        }
        System.out.println();
    }
}