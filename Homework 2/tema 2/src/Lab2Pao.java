import java.util.*;

public class Lab2Pao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tablou = new int[10];
		for (int i = 0 ; i < tablou.length ; i++) {
			tablou[i] = i; 
//			System.out.print(tablou[i] + " ");
		}
		String s1 = "a";
		String s2 = "b";
		
		s1 = s1 + s2;
//		System.out.println(s1);
		
		int[] a = {4, 1, 10, 43, 2, 15};
		Arrays.parallelSort(a);
		for (int i = 0 ; i < a.length ; i++) {
			System.out.println(a[i]);
		}
		
		
	}

}
