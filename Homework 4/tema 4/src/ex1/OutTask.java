package ex1;

public class OutTask implements Task {
	String message;
	
	public OutTask(String message) {
		this.message = message;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
