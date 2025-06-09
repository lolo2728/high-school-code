package picoCTF;
 
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class JavaPassword {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String salt = "1234";
        String unecryptedPassword = "swag";
        System.out.println("Unencrypted Password: " + unecryptedPassword);
         
        MessageDigest messageDigest=null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update((unecryptedPassword+salt).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}