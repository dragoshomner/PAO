import java.util.Scanner;

public class ex3 {
	
	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] img = new int[100][100];
		int[][] newImg = new int[100][100];
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int m = Integer.parseInt(sc.nextLine());
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				img[i][j] = Integer.parseInt(sc.nextLine());
				newImg[i][j] = isPrime(img[i][j]) ? 0 : 1;
				counter = (newImg[i][j] == 1) ? counter + 1 : counter;
			}
		}
		System.out.println(counter);
		sc.close();
	}

}
