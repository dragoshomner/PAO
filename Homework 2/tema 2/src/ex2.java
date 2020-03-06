import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		int[] par = new int [100]; 
		int[] impar = new int [100];
		int lenPar = 0, lenImpar = 0;
		
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		for (int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			if (x % 2 == 0) {
				impar[lenImpar] = x;
				lenImpar ++;
			}
			else {
				par[lenPar] = x;
				lenPar ++;
			}
		}
		
		if (lenPar > lenImpar) {
			for (int i = 0 ; i < lenPar ; i++) {
				System.out.println(par[i]);
			}
		}
		else {
			for (int i = 0 ; i < lenImpar ; i++) {
				System.out.println(impar[i]);
			}
		}
		
		sc.close();
	}

}
