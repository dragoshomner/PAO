import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		StringBuilder[] a = new StringBuilder[100];
		StringBuilder[] b = new StringBuilder[100];
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < n; i++) {
			a[i] = new StringBuilder(sc.nextLine());
		}
		
		int counter = 0, max_length = 0;
		String max_string = null;
		for (int i = 0; i < n; i++) {
			String reverse = a[i].reverse().toString();
			if (reverse.toString().equals(a[i].reverse().toString())) {
				if (a[i].length() > max_length) {
					max_string = a[i].toString();
				}
				b[counter++] = new StringBuilder(a[i]);
			}
		}
		
		System.out.println(max_string);
		
		sc.close(); 
		
	}

}
