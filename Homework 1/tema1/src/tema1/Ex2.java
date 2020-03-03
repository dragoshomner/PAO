package tema1;

import java.util.Scanner;
import java.lang.Math;

public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(Math.max(a, b));
		
		sc.close();
	}

}
