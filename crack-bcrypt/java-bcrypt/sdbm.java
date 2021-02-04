// PT Dymar Jaya Indonesia
// sdbm - search database matching
// searching list bcrypt database with spesific password
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.RuntimeException;

public class sdbm {
    
    public static void main(String[] args) {

			if ((args.length != 2)) {
    System.out.println("Usage: ");
    System.out.println("java sdbm <Bcrypt Database File Name> <Clear Password> ");
    return;
    }
		
		String word = args[1];
		Scanner s = null;
		try{
			s = new Scanner(new File(args[0]));
			bcrypttest bctest = new bcrypttest();
			while(s.hasNextLine()){
				String bcrypt = s.nextLine(); 
				boolean verify = bctest.verifyHash(word, bcrypt);
				if(verify == true){
				 System.out.println(bcrypt);
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
    }
    
    /*
     * generate BCrypt hash
     */
    public String generateHash(String plainText) {
        try {
            
            String salt = BCrypt.gensalt(10, SecureRandom.getInstance("SHA1PRNG"));
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
