package ex1;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	private static final String path = "src/ex1/out.txt";

	private static void clearFile() {
		try {
			PrintWriter out = new PrintWriter(path);
			out.write("");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws OrderException {
		Scanner sc = new Scanner(System.in);
		int n, a, b;
		n = sc.nextInt();
		clearFile();
		for (int i = 0; i < n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			try {
				if (a < b) {
					try {
						FileOutputStream out = new FileOutputStream(path, true);
						out.write((a + " " + b + "\n").getBytes());
						out.close();
					} catch (FileNotFoundException e) {
						System.out.println("File not found!");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					throw new OrderException("Primul numar trebuub paie sa fie mai mic");
				}
			} catch(OrderException e) {
				i--;
				System.err.println(e.getMessage());
			}
		}
		sc.close();
	}

}
