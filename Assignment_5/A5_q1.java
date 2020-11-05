public class A5_q1 extends Thread{

    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println(i); // print number
            if (i%10==0){
                System.out.println("Ten numbers counted!"); // print string after 10 numbers
            }
            try {
                Thread.sleep(1000); // put thread to sleep for 1 sec
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("Unable to put thread to sleep!");
            }
        }

    }

    public static void main(String[] args) {
        A5_q1 object = new A5_q1();
        object.start(); // start thread

    }
}
