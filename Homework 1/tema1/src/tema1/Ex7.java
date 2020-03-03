package tema1;

import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if (n == 1 || n == 2) {
			System.out.println(1);
		}
		else {
			int a, b, c;
			a = b = 1;
			c = a + b;
			for (int i = 2 ; i < n ; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			System.out.println(c);
		}
		
		sc.close();
	}
}
