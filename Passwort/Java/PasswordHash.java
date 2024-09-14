import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Provides a singleton object to hash a password with the given algorithm.
 */
public class PasswordHash {

	/**
	 * Singleton object.
	 */
	private static final PasswordHash hashInstance = new PasswordHash();
	
	/**
	 * Singleton constructor.
	 */
	private PasswordHash(){
		/* empty private constructor */
	}
	
	/**
	 * Returns the only instance of the given hash function.
	 * @return The instance of the hash function
	 */
	public static PasswordHash getInstance() {
		return hashInstance;
	}
	
	/**
	 * Hashes a password with a given salt using SHA-512.
	 * @param password The password to be hashed
	 * @param salt The salt used for the hash
	 * @return A Base-64 encoded hash value in string representation
	 */
	public String hash(String password, String salt) {
		String hash = "";
		try {
			// Calculate hash value for message string
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes());
			byte[] byteResult = md.digest(password.getBytes());
		
        	hash = Base64.getEncoder().encodeToString(byteResult);
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// Return pattern: $our-special-sha-512$salt$hashvalue in Base-64 encoding
		return "$42$" + salt + "$" + hash;
	}
}
