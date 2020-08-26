import java.util.HashSet;

public class q5_2 {
    private static HashSet<Integer> union(HashSet<Integer> A, HashSet<Integer> B) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < 11; i++) {
            if (A.contains(i) || B.contains(i)) {
                temp.add(i);
            }
        }
        return temp;
    }

    private static HashSet<Integer> intersection(HashSet<Integer> A, HashSet<Integer> B) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < 11; i++) {
            if (A.contains(i) && B.contains(i)) {
                temp.add(i);
            }
        }
        return temp;
    }

    private static HashSet<Integer> complement(HashSet<Integer> A) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (int i = 0; i < 11; i++) {
            if (!A.contains(i)) {
                temp.add(i);
            }
        }
        return temp;
    }

    public static double[] main(String[] args, HashSet<Integer> setA, HashSet<Integer> setB) {
        
        double[] timeElapsedArray = new double[4];

        System.out.println("\nUsing HashSet: ");

        System.out.print("\nUnion: ");
        long startTime = System.nanoTime();
        HashSet<Integer> output = union(setA, setB);
        double elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);
        timeElapsedArray[0] = elapsedTime;

        System.out.print("\nIntersection: ");
        startTime = System.nanoTime();
        output = intersection(setA, setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);
        timeElapsedArray[1] = elapsedTime;

        System.out.print("\nComplement(A): ");
        startTime = System.nanoTime();
        output = complement(setA);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);
        timeElapsedArray[2] = elapsedTime;

        System.out.print("\nComplement(B): ");
        startTime = System.nanoTime();
        output = complement(setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime);
        timeElapsedArray[3] = elapsedTime;

        return timeElapsedArray;
    }

}