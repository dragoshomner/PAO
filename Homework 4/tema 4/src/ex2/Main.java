package ex2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Album[] albume = new Album[5];
		albume[0] = new Album("The Beatles", 1968, 100);
		albume[1] = new Album("Blue", 1971, 80);
		albume[2] = new Album("Nevermind", 1991, 90);
		albume[3] = new Album("Horses", 1975, 70);
		albume[4] = new Album("Purple Rain", 1984, 75);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(albume[i]);
		}
		System.out.println("-----------------------------");
		
		Arrays.sort(albume, new AlbumComparator());
		
		for (int i = 0; i < 5; i++) {
			System.out.println(albume[i]);
		}
	}
}
