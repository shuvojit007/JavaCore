package ACM;

import java.util.ArrayList;
import java.util.Scanner;

public class Dev_Point {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        n = in.nextInt();
        for (int i = 1; i <=n; i++) {
            int  U, M, Q;
            ArrayList <Integer> User = new ArrayList();
            ArrayList <Integer>Offer = new ArrayList();
            U = in.nextInt();
            M = in.nextInt();
            Q = in.nextInt();
            for (int ui = 0; ui < U; ui++) {
                User.add(in.nextInt());
            }

            for (int mi = 0; mi < M; mi++) {
                Offer.add(in.nextInt());
            }
                 int of=0;
            for (int qi = 0; qi < Q; qi++) {
                int x, y, l, R;
                 x=in.nextInt();
                y=in.nextInt();
                l=in.nextInt();
                R=in.nextInt();

                for(int lp=x-1;lp<y;lp++)
                {
                    of+=Offer.get(lp);
                }
                int ans=0;
                for(int lp=l-1;lp<R;lp++){
                    User.set(lp,User.get(lp)+of);

                }


            }
            System.out.println("Case "+i+":");
            int vl =User.get(User.size()-1);

            for(int ans :User){
                if(ans==vl){
                    System.out.print(ans);
                }else {
                    System.out.print(ans+" ");
                }
            }

        }
    }
}
