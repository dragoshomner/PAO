package services;

import models.Customer;
import models.Marketplace;
import repositories.MarketplaceRepository;
import utils.MyLogger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MarketplaceService {

	private final MarketplaceRepository marketplaceRepository;

	public MarketplaceService(MarketplaceRepository marketplaceRepository) {
		this.marketplaceRepository = marketplaceRepository;
	}
	
	public void add(Marketplace marketplace) {
		marketplaceRepository.add(marketplace);
	}

	public void addBulk(List<Marketplace> marketplaces) {
		for (Marketplace marketplace : marketplaces) {
			marketplaceRepository.add(marketplace);
		}
	}

	public void addBulkString(List<List<String>> input) {
		for (List<String> marketplaceString : input) {
			Marketplace marketplace = new Marketplace(marketplaceString.get(0), marketplaceString.get(1));
			marketplaceRepository.add(marketplace);
		}
	}

	public Marketplace findByCode(String code) {
		return marketplaceRepository.findByCode(code);
	}

	public void displayAll() {
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		if (listOfMarketplaces.isEmpty()) {
			System.out.println("No marketplaces");
			return ;
		}
		for (Marketplace m : listOfMarketplaces) {
			m.show();
		}

		MyLogger.write("displayAll");
	}

	public void displayAllSortedByName() {
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getName));
		for (Marketplace m : sortedList) {
			m.show();
		}

		MyLogger.write("displayAllSortedByName");
	}

	public void displayAllSortedByNumberOfCustomers() {
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getNumberOfCustomers).reversed());
		for (Marketplace m : sortedList) {
			m.show();
		}

		MyLogger.write("displayAllSortedByNumberOfCustomers");
	}
	
	public void displayCustomersPerMarketplace() {
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		for (Marketplace m : listOfMarketplaces) {
			System.out.println("------------------------------");
			System.out.println("Nume: " + m.getName());
			for (Customer customer : m.getCustomers()) {
				System.out.println(customer.getName());
			}
		}

		MyLogger.write("displayCustomersPerMarketplace");
	}

	public List<String> toCSV() {
		return marketplaceRepository.toCSV();
	}
	
}
