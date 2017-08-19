package Leet_Code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by SHOBOJIT on 7/12/2017.
 */
public class Reverse_Integer {
        public int reverse(int x) {
            long result=0;

            while(x!=0){
                result =(result*10)+(x%10);
                if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) {
                    System.out.println(result);
                    return 0;
                }
                x = x/10;
            }
            return (int)result;
        }

 @Test
    public void Test(){
    assertEquals(0, new Reverse_Integer().reverse(1534236469));
     assertEquals(135, new Reverse_Integer().reverse(531));
     assertEquals(-531, new Reverse_Integer().reverse(-135));

 }
}
