import java.util.Scanner;

public class q5_1 {
    private static boolean[] union(boolean[] A, boolean[] B) {
        boolean[] temp = new boolean[11];
        for (int i = 0; i < 11; i++) {
            if (A[i] || B[i]) {
                temp[i] = true;
            }
        }
        return temp;
    }

    private static boolean[] intersection(boolean[] A, boolean[] B) {
        boolean[] temp = new boolean[11];
        for (int i = 0; i < 11; i++) {
            if (A[i] && B[i]) {
                temp[i] = true;
            }
        }
        return temp;
    }

    private static boolean[] complement(boolean[] A) {
        boolean[] temp = new boolean[11];
        for (int i = 0; i < 11; i++) {
            if (A[i] == false) {
                temp[i] = true;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of Set A: ");
        int n = input.nextInt();
        input.nextLine();
        boolean[] setA = new boolean[11];
        System.out.print("Enter elements of Set A: ");
        for (int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if (temp < 0 || temp > 10) {
                System.out.println("Invalid Input!!");
                return;
            }
            setA[temp] = true;
        }
        input.nextLine();
        System.out.print("Enter size of Set B: ");
        int m = input.nextInt();
        input.nextLine();
        boolean[] setB = new boolean[11];
        System.out.print("Enter elements of Set B: ");
        for (int i = 0; i < m; i++) {
            int temp = input.nextInt();
            if (temp < 0 || temp > 10) {
                System.out.println("Invalid Input!!");
                return;
            }
            setB[temp] = true;
        }
        System.out.print("\nUnion: ");
        long startTime = System.nanoTime();
        boolean[] output = union(setA, setB);
        double elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);

        System.out.print("\nIntersection: ");
        startTime = System.nanoTime();
        output = intersection(setA, setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);

        System.out.print("\nComplement(A): ");
        startTime = System.nanoTime();
        output = complement(setA);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);

        System.out.print("\nComplement(B): ");
        startTime = System.nanoTime();
        output = complement(setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);

        input.close();
    }

}