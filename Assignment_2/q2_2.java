import java.util.Scanner;

public class q2_2 {
    private static void countingSort(int[] arr) {
        int[] count = new int[21];
        for (int i : arr) {
            if (i < 0 || i > 20) {
                System.out.println("Invalid Input: " + i);
                return;
            }
            count[i]++;
        }
        int k = 0;
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
        int n = input.nextInt();
        input.nextLine();
        int[] arr = new int[n];
        System.out.print("Enter Elements(Separated by space): ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println();
        countingSort(arr);
        System.out.print("Output: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}