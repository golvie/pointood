import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class testMD5 {

	public testMD5() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {


		String pwd = "zzz";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pwd.getBytes());

		   
		byte messageDigest[] = md.digest();
		StringBuffer hexString = new StringBuffer();

		for (int i=0;i<messageDigest.length;i++) {
			   String hex = Integer.toHexString(0xFF & messageDigest[i]); 
			   if(hex.length()==1)
				   hexString.append('0');
			   hexString.append(hex);
		}
		String hashedPassword = hexString.toString();
		System.out.println(hashedPassword);
	}

}
