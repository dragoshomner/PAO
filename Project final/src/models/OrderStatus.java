package models;

import java.util.List;

public class OrderStatus {
	private static int MAX_NUMBER;
	private static String[] status;
	private int currentStatus;
	private String name;
	
	public OrderStatus() {
		this.currentStatus = 0;
	}

	public OrderStatus(String name) {
		this.name = name;
	}
	
	public static void initialize(List<List<String>> input) {
		MAX_NUMBER = input.size();
		status = new String[MAX_NUMBER];
		for (int index = 0; index < MAX_NUMBER; index ++) {
			status[index] = input.get(index).get(0);
		}
	}
	
	public void nextStatus() {
		if (currentStatus < MAX_NUMBER - 1) {
			currentStatus ++;
		}
	}
	
	public String getStatus() {
		return status[currentStatus];
	}

	public String getName() { return name; }

	@Override
	public String toString() {
		return "OrderStatus{" +
				"name='" + name + '\'' +
				'}';
	}
}
