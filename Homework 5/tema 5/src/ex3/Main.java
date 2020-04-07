package ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static final String path = "src/ex3/clienti.txt";

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(new File(path));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		ArrayList<Person> people = new ArrayList<Person>();
		while ((line = reader.readLine()) != null) {
			String[] words = line.split("\\s+");
			Person person = new Person(words[0], words[1], Integer.parseInt(words[2]));
			people.add(person);
		}
		System.out.println(people.size());
		
		System.out.println("Persoane minore:");
		for (Person p : people) {
			if (p.isMinor()) {
				System.out.println(p.toString());
			}
		}
		System.out.println();
		System.out.println("Persoane majore:");
		for (Person p : people) {
			if (!p.isMinor()) {
				System.out.println(p.toString());
			}
		}
		
		reader.close();
	}

}
