import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		int sum = 0, n = 0, x;
		while ((x = sc.nextInt()) != -1) {
			n ++;
			sum += x;
		}
		System.out.println((float)sum / n);
		
		sc.close();
	}

}
