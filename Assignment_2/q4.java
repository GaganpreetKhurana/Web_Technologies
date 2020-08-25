import java.util.Scanner;

public class q4 {
    public static Long smallestNumber(Long n) {
        Long sum = (long) 0;
        for (Long i = (long) 1; i <= n; i++) {
            sum += i;
            if (sum == (i * i)) {
                return i;
            }
        }
        return Long.MIN_VALUE;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");
        Long n = input.nextLong();
        input.close();
        System.out.println("Smallest Number: " + smallestNumber(n));
    }
}