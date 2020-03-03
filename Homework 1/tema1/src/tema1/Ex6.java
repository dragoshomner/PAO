package tema1;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int ans = (int) Math.pow(a, b);
		
		System.out.println(ans);
		
		sc.close();
	}

}
