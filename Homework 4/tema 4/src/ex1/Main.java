package ex1;

public class Main {
	public static int counter = 0;

	public static void main(String[] args) {
		OutTask o1 = new OutTask("Trebuie sa scrii tema");
		o1.execute();
		
		RandomOutTask r1 = new RandomOutTask();
		r1.execute();
		
		CounterOutTask c1 = new CounterOutTask();
		c1.execute();
		c1.execute();
	}

}
