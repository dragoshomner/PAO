import java.util.ArrayList;
import java.util.Comparator;

public class MarketplaceService {
	private ArrayList<Marketplace> listOfMarketplaces;

	public MarketplaceService() {
		listOfMarketplaces = new ArrayList<Marketplace>();
	}
	
	public void addMatketplace(Marketplace marketplace) {
		listOfMarketplaces.add(marketplace);
	}
	
	public void displayAll() {
		if (listOfMarketplaces.isEmpty()) {
			System.out.println("No marketplaces");
			return ;
		}
		for (Marketplace m : listOfMarketplaces) {
			m.show();
		}
	}

	public void displayAllSortedByName() {
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getName));
		for (Marketplace m : sortedList) {
			m.show();
		}
	}

	public void displayAllSortedByNumberOfCustomers() {
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getNumberOfCustomers).reversed());
		for (Marketplace m : sortedList) {
			m.show();
		}
	}
	
	public void displayCustomersPerMarketplace() {
		for (Marketplace m : listOfMarketplaces) {
			System.out.println("------------------------------");
			System.out.println("Nume: " + m.getName());
			for (Customer customer : m.getCustomers()) {
				System.out.println(customer.getName());
			}
		}
	}
	
}
