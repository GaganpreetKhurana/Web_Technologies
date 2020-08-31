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

    public static double[] main(String[] args, boolean[] setA, boolean[] setB) {

        double[] timeElapsedArray = new double[4];

        System.out.println("\nUsing Array: ");

        System.out.print("\nUnion: ");
        long startTime = System.nanoTime();
        boolean[] output = union(setA, setB);
        double elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime + " ms");
        timeElapsedArray[0] = elapsedTime;

        System.out.print("\nIntersection: ");
        startTime = System.nanoTime();
        output = intersection(setA, setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime + " ms");
        timeElapsedArray[1] = elapsedTime;

        System.out.print("\nComplement(A): ");
        startTime = System.nanoTime();
        output = complement(setA);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime + " ms");
        timeElapsedArray[2] = elapsedTime;

        System.out.print("\nComplement(B): ");
        startTime = System.nanoTime();
        output = complement(setB);
        elapsedTime = (System.nanoTime() - startTime) / 1000000.0;
        for (int i = 0; i < 11; i++) {
            if (output[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nTime Elapsed: " + elapsedTime + " ms");
        timeElapsedArray[3] = elapsedTime;

        return timeElapsedArray;
    }

}