package ex1;

public class CounterOutTask implements Task {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Main.counter ++;
		System.out.println("Contorul are valoarea: " + Main.counter);
	}

}
