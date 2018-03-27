package DSAUdemy;
import java.util.Scanner;
/*
Link -> https://mukitmkbs.wordpress.com/2014/09/30/big-mod/
 */


public class BigMod {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b, m;
        System.out.println("Find the bigmod");
        a = in.nextInt();
        b = in.nextInt();
        m = in.nextInt();
        System.out.println("Result is :" + Bmod2(a, b, m));
    }

    /*
    (a*b)%m = ((a%m)*(b%m))%m
    (x^y)*(x^z) = x^(y+z)
    (x^y)^z = x^(yz)
    x^0 = 1
     */


    public static int Bmod(int a, int b, int m) {
        if (b == 0)
            return 1;
        int x = Bmod(a, b / 2, m);
        x = (x * x) % m;
        if (b % 2 == 1)
            x = (x * a) % m;
        return x;
    }

    public static int Bmod2(int a, int b, int m) {
        int y;
        if (b == 0) {
            return 1;
        } else if (b % 2 == 0) {
            y = Bmod2(a, b / 2, m);
            return ((y * y) % m);
        } else {
            return (((a % m) * Bmod2(a, b - 1, m)) % m);
        }
    }
}
