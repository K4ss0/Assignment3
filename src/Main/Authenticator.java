package Main;

import java.util.Scanner;

public class Authenticator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "UserData";
		User[] users = Collector.readUserDataFromFile(filePath);
		Scanner scanner = new Scanner(System.in);
		int maxAttempts = 5;
		int attempts = 0;
				
		while (attempts < maxAttempts) {
			System.out.println("Enter UserName: ");
			String userName = scanner.nextLine();
			System.out.println("Enter Password: ");
			String password = scanner.nextLine();
			
			User userCheck = findUser(users, userName);
					
			if (userCheck != null && userCheck.getPassword().equals(password)){
				System.out.println("Welcome, " + userCheck.getName());
				break;
			}else {
				attempts++;
				if (attempts == maxAttempts) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					scanner.close();
					break;
				} else {
					System.out.println("Invalid login, please try again.");
				}
			}
		}
	}

	public static User findUser(User[] users, String userName) {
		for(User user : users) {
			if (user.getUserName().equalsIgnoreCase(userName)) {
				return user;
				}
		}
		return null;
	}
}
	
