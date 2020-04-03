
public class OrderStatus {
	private final int MAX_NUMBER = 3;
	private String[] status;
	private int currentStatus;
	
	public OrderStatus() {
		initializeStatus();
		this.currentStatus = 0;
	}
	
	private void initializeStatus() {
		status = new String[MAX_NUMBER];
		status[0] = "Plasata";
		status[1] = "Platita";
		status[2] = "Trimisa";
	}
	
	public void nextStatus() {
		if (currentStatus < MAX_NUMBER - 1) {
			currentStatus ++;
		}
	}
	
	public String getStatus() {
		return status[currentStatus];
	}
}
