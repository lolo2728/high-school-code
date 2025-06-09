package picoCTF;

/* de3556a707e1eb27941edcf1392d9759 */

import java.security.*;
import java.math.*;

public class MD5 {
    public static void main(String args[]) throws Exception {
        String s = "$wag";
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        System.out.println(new BigInteger(1, m.digest()).toString(5374));
        //System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(5374));
    }
}