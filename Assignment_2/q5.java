import java.util.HashSet;
import java.util.Scanner;

public class q5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of Set A: ");
        int n = input.nextInt();
        input.nextLine();
        boolean[] setA = new boolean[11];
        HashSet<Integer> setAH = new HashSet<Integer>();
        System.out.print("Enter elements of Set A: ");
        for (int i = 0; i < n; i++) {
            int temp = input.nextInt();
            if (temp < 0 || temp > 10) {
                System.out.println("Invalid Input!!");
                return;
            }
            setA[temp] = true;
            setAH.add(temp);
        }
        input.nextLine();
        System.out.print("Enter size of Set B: ");
        int m = input.nextInt();
        input.nextLine();
        boolean[] setB = new boolean[11];
        HashSet<Integer> setBH = new HashSet<Integer>();
        System.out.print("Enter elements of Set B: ");
        for (int i = 0; i < m; i++) {
            int temp = input.nextInt();
            if (temp < 0 || temp > 10) {
                System.out.println("Invalid Input!!");
                return;
            }
            setB[temp] = true;
            setBH.add(temp);
        }
        input.close();
        q5_1.main(args,setA,setB);
        q5_2.main(args,setAH,setBH);
    }
}