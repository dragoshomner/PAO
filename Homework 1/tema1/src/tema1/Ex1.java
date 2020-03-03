package tema1;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0 ; i < n + 1 ; i += 2) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}
}
