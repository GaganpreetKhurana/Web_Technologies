public class q2_4 {
    public static int smallestNumber() {
        Long sum = (long) 0;
        int smallest = 1;
        int i = 1;
        while (i * i > 0) {
            sum += i;
            if (sum == i * i) {
                if (smallest == 0 || i < smallest) {
                    // smallest == 0 for first state when condition is satisfied
                    smallest = i;
                }
            }
            i++;
        }
        return smallest;
    }

    public static void main(String[] args) {
        System.out.println("Smallest Number: " + smallestNumber());
    }
}