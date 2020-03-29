package ex1;

public class RandomOutTask implements Task {
	int randomNumber;
	
	public RandomOutTask() {
		this.randomNumber = (int) (Math.random() * 1000 + 1);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Am generat numarul: " + this.randomNumber);
	}

}
