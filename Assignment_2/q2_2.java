import java.util.Scanner;

public class q2_2 {
    private static void countingSort(int[] arr) {
        // Range [0,20]
        int[] count = new int[21]; // Array to store frequencies
        for (int i : arr) {
            if (i < 0 || i > 20) {
                // Check input validity
                System.out.println("Invalid Input: " + i);
                return;
            }
            count[i]++;
        }
        int k = 0; // Counter to traverse Array arr
        for (int i = 0; i < 21; i++) {
            while (count[i] > 0) {
                arr[k] = i;
                k++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of Elements: ");
        int n = input.nextInt(); // Number of elements
        input.nextLine();
        int[] arr = new int[n];
        System.out.print("Enter Elements(Separated by space): ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt(); // Input elements
        }
        input.close();
        System.out.println();
        countingSort(arr); // Counting Sort
        System.out.print("Output: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}