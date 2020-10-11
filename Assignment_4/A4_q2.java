public class A4_q2 {
    public static void main(String[] args) {
        int var = -1;
        byte var_byte = (byte) var;
        char var_char = (char) var_byte;
        int var_int = (int) var_char;
        System.out.println("Int: " + var);
        System.out.println("Byte: " + var_byte);
        System.out.println("Char: " + var_char);
        System.out.println("Int: " + var_int);
        if (var == var_int) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

    }
}
