package ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static final String path = "src/ex2/parole.txt";
	
	public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
		ArrayList<User> users = new ArrayList<User>();
		InputStream in = new FileInputStream(new File(path));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("\\s+");
			try {
				User newUser = new User(words[0], words[1]);
				users.add(newUser);
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Out of index");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		reader.close();
		
		int numberOfTriesPassword = 0, numberOfTriesTotal = 0;
		boolean isLogging = true;
		Scanner sc = new Scanner(System.in);
		while (isLogging == true) {
			String[] input = sc.nextLine().split("\\s+");
			User tryUser = new User(input[0], input[1]);

			boolean passwordWrong = false;
			for (User user : users) {
				if (tryUser.equals(user)) {
					isLogging = false;
					break;
				}
				if (tryUser.getName().equals(user.getName())) {
					passwordWrong = true;
					break;
				}
			}
			if (isLogging == false) {
				System.out.println("Te-ai logat!");
			}
			else {
				if (isLogging == true && passwordWrong == true) {
					numberOfTriesPassword ++;
					System.out.println("Parola e gresita!");
				}
				else {
					numberOfTriesPassword = 0;
					System.out.println("Inregistrarea nu exista!");
				}
				numberOfTriesTotal++;
			}
			
			if (numberOfTriesPassword >= 3) {
				isLogging = false;
				System.out.println("Contul a fost blocat!");
				continue;
			}
			if (numberOfTriesTotal >= 5) {
				isLogging = false;
				System.out.println("Nu ai cont. Inregistreaza-te!");
			}
		}
		sc.close();
		
	}
}
