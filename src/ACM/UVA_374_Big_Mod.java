package ACM;

import java.util.Scanner;

public class UVA_374_Big_Mod {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b, m;
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            m = in.nextInt();
            System.out.println(Bmod(a, b, m));
        }
    }

    private static int Bmod(int a, int b, int m) {
        int y;
        if (b == 0) {
            return 1;
        } else if (b % 2 == 0) {
        y=Bmod(a,b/2,m);
        return ((y*y)%m);
        }else {
            return (((a%m)*Bmod(a,b-1,m))%m);
        }
    }
}
