
public class Main {

	public static void main(String[] args) {

		// Example use of hash function
		String hash = "$42$12salt34$rLGE6snqDMod/fcG1kaBcsaohODHTc27xZpDFvh4UIiA/voH323UOQCLfDG07/NmmID4UAa8BevwDHVVqZu77g==";
		
		String testPassword = "Cybersecurity";
		String testSalt = "12salt34";
		String test = PasswordHash.getInstance().hash(testPassword, testSalt);
		
		System.out.println("Original hash: " + hash);
		System.out.println("Computed hash: " + test);
		
		if(hash.equals(test))
			System.out.println("Match!");
		else
			System.out.println("No match.");
	}

}
