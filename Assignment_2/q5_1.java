import java.util.Scanner;

public class q5_1 {
    private static void union(boolean[] A, boolean[] B) {
        for (int i = 0; i < 11; i++) {
            if (A[i] || B[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void intersection(boolean[] A, boolean[] B) {
        for (int i = 0; i < 11; i++) {
            if (A[i] && B[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void complement(boolean[] A) {
        for (int i = 0; i < 11; i++) {
            if (A[i] == false) {
                System.out.print(i + " ");
            }
        }
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
        union(setA, setB);
        System.out.print("\nIntersection: ");
        intersection(setA, setB);
        System.out.print("\nComplement(A): ");
        complement(setA);
        System.out.print("\nComplement(B): ");
        complement(setB);
        input.close();
    }

}