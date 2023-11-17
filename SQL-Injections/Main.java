import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class Main {

	public static void main(String[] args)
	{
		try
		{
			// Disable certificate validation
			// Should not be necessary, because the certificate works just fine, but Java is weird
			// From https://stackoverflow.com/q/54516557
			SSLContext context = SSLContext.getInstance("TLSv1.3");
			TrustManager[] trustManager = new TrustManager[]
			{
					new X509TrustManager()
					{
						public X509Certificate[] getAcceptedIssuers()
						{
							return new X509Certificate[0];
						}
						public void checkClientTrusted(X509Certificate[] certificate, String str) {}
						public void checkServerTrusted(X509Certificate[] certificate, String str) {}
					}
			};
			context.init(null, trustManager, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
			
			// Example use of hash function
			String hash = "5c5765aa7224eab733473471dd6abcb9d15d5e18";
			
			String testPassword = "Luebeck";
			String test = hash(testPassword);
			
			System.out.println("Original hash: " + hash);
			System.out.println("Computed hash: " + test);
			
			if(hash.equals(test))
				System.out.println("Match!");
			else
				System.out.println("No match.");
				
			// Example HTTP request
			System.out.println("HTTP Response:");
			System.out.println(httpGetRequest("https://teaching.its.uni-luebeck.de/cs/lab/sql-php/blindsqlinjection/"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Hashes a password using SHA-1.
	 * @param password The password to be hashed
	 * @return Hash value as string
	 */
	public static String hash(String password)
	{
		try
		{
			// Calculate hash value for message string
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] byteResult = md.digest(password.getBytes());
		
        	return bytesToHex(byteResult);
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Converts a byte array to a hexadecimal string.
	 * Adapted from https://stackoverflow.com/a/9855338
	 */
	public static String bytesToHex(byte[] bytes)
	{
		char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for(int j = 0; j < bytes.length; j++)
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}
	
	/**
	 * Executes a HTTP GET request for the given URL, and returns the response.
	 */
	public static String httpGetRequest(String urlString)
	{
		try
		{
			URL url = new URL(urlString);

			// Open connection
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

			// Run request
			con.setRequestMethod("GET");
			con.getResponseCode();

			// Read response line by line
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while((inputLine = in.readLine()) != null)
			{
				content.append(inputLine);
			}
			
			// Cleanup
			in.close();
			con.disconnect();
			
			return content.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
