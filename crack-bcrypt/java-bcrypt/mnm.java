// PT Dymar Jaya Indonesia
// mnm - mix and match
// mix between bfda and sdbm functionality
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.RuntimeException;
import java.util.*;

public class mnm {
    
    public static void main(String[] args) {

	if ((args.length != 2)) {
    System.out.println("Usage: ");
    System.out.println("java mnm <Bcrypt Database File Name> <Dictionary File Name> ");
    return;
    }
		
		Scanner s, ss = null;
		try{
			s = new Scanner(new File(args[0]));
			ss = new Scanner(new File(args[1]));
			bcrypttest bctest = new bcrypttest();
					
			List<String> temps = new ArrayList<String>();
			while (ss.hasNext()){
			String word = ss.next(); 
			temps.add(word);
				
			}
			ss.close();
			
			List<String> temps2 = new ArrayList<String>();
			while (s.hasNext()){
			String bc = s.next(); 
			temps2.add(bc);
				
			}
			s.close();
			
			String[] bcrypt = temps2.toArray(new String[0]);
			String[] words = temps.toArray(new String[0]);
			
			for (int i=0; i< words.length ; i++){
				for (int j=0; j< bcrypt.length ; j++){
					boolean verify = bctest.verifyHash(words[i], bcrypt[j]);
					if(verify == true){
						System.out.println(bcrypt[j] + ":" + words[i] );
					}
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
