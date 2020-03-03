package tema1;

import java.util.Scanner;

public class Ex4 {
	private static int factorial(int n) {
		int ans = 1;
		for (int i = 1 ; i <= n ; i++) {
			ans *= i;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fact = factorial(n);
		System.out.println(fact);
		sc.close();		
	}
}
