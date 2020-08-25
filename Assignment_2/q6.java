import java.util.Scanner;

public class q6 {
    public static void hailstoneSeq(long n) {
        if (n <= 0) {
            System.out.println("Invalid Range");
            return;
        }
        while (n != 1) {
            System.out.print(n + " ");
            if (n % 2 == 0) {

                n /= 2;
            } else {
                n *= 3;
                n++;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        long n = input.nextInt();
        input.close();
        System.out.println("Hailstone Sequence: ");
        hailstoneSeq(n);
    }

}