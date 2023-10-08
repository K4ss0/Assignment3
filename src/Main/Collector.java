package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Collector {

	public static void main(String[] args) {
		String filePath = "UserData"; 
		User[] users = readUserDataFromFile(filePath);
	}
		
	public static User[]readUserDataFromFile(String filePath){
		User[] users = new User[4];
		
		try(FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader)){
			
			String line;
			int userCount = 0;
			while ((line = bufferedReader.readLine()) != null){
				String[]parts = line.split(",");
				if (parts.length == 3 ) {
					String userName = parts [0];
					String password = parts [1];
					String name = parts[2];
					
					users[userCount] = new User(userName, password, name);
					
					userCount++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
		}
}
