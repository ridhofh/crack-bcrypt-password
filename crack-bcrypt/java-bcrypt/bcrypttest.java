// PT Dymar Jaya Indonesia
// Bcrypt test
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class bcrypttest {
    
    public static void main(String[] args) {
	if ((args.length != 1)) {
    System.out.println("Usage: ");
    System.out.println("java bcrypttest <Data>");
    return;
    }
	String data = args[0];
        bcrypttest bcTest = new bcrypttest();
        String bcrypt = bcTest.generateHash(data);
	System.out.println("data: " + data);
	String prefix = bcrypt.substring(1, 1+2);
	System.out.println("prefix: " + prefix);
	String round = bcrypt.substring(4, 4+2);
	System.out.println("log rounds: " + round);
	String salt = bcrypt.substring(7, 7+22);
	System.out.println("salt: " + salt);
	String hashed = bcrypt.substring(29,bcrypt.length());
	System.out.println("hash: " + hashed);
        boolean verify = bcTest.verifyHash(data, bcrypt);
        System.out.println("bcrypt: " +bcrypt);
        //System.out.println("verify: "+verify);
    }
    
    /*
     * generate BCrypt hash
     */
    public String generateHash(String plainText) {
        try {
			String prefix = "$2a"; //version: $2a, $2y, $2b
            int log_rounds = 10; //cost factor. min:4, max:31
            String salt = BCrypt.gensalt(prefix,log_rounds, SecureRandom.getInstance("SHA1PRNG"));
            return BCrypt.hashpw(plainText, salt);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    /*
     * BCrypt check
     */
    public boolean verifyHash(String plainText, String cipher) {
        return BCrypt.checkpw(plainText, cipher);
    }
}
