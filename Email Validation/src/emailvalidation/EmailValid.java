package emailvalidation;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValid {
	
	static String[] emailDatabase = new String[] {"email1@server1.com", "email2@server2.com", 
			"email3@server1.com", "email3@server1.com", "email4@server4.com", "email5@server5.com",
			"email6@server6.com", "email7@server7.com", "email8@server8.com"};
	
		
	static boolean mailValidation (String emailID) { 
		//Considering Regex for RFC-5322 Validation
		// credit to https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
		
		String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailID);
		//Considering Regex for RFC-5322 Validation
		if (matcher.matches()) {
			System.out.println("You have entered a valid email ID.");
			return true;
		} else {
			System.out.println("You have entered an invalid email ID.\n\n");
			return false;			
		}		
	}

	static boolean mailConfirmation (String emailID) { 
		//Considering Regex for RFC-5322 Validation
		// credit to https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
		
		String regex = emailID;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		for (String email: emailDatabase) {
			matcher = pattern.matcher(email);
		//Considering Regex for RFC-5322 Validation
			if (matcher.matches()) {
				System.out.println("\n\nGreat! Your email has been identified.");
				return true;
			} 			
		}
		System.out.println("\n\nUnfortunately, your email has not been identified.");
		return false;		
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// prompting a user to enter an email ID
		boolean flag;
		String emailID;
		do {
			System.out.println("Enter a valid email ID: ");
			emailID = scanner.nextLine();
			System.out.println("You have entered: "+emailID);
			flag = !mailValidation(emailID);
			
		} while (flag);
		mailConfirmation(emailID);
	}
}
