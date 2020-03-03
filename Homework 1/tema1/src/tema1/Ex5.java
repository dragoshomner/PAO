package tema1;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		boolean prim = true;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 2 ; i <= n / 2 ; i++) {
			if (n % i == 0) {
				prim = false;
				break;
			}
		}
		if (prim) {
			System.out.println("E prim");
		}
		else {
			System.out.println("NU e prim");
		}
		
		sc.close();
	}

}
