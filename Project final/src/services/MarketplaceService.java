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

	public String displayAll() {
		String result = "";
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		if (listOfMarketplaces.isEmpty()) {
			result = "No marketplaces";
			return result;
		}
		for (Marketplace m : listOfMarketplaces) {
			result += m.toString() + '\n';
		}

		MyLogger.write("displayAll");

		return result;
	}

	public String displayAllSortedByName() {
		String result = "";
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getName));
		for (Marketplace m : sortedList) {
			result += m.toString() + '\n';
		}

		MyLogger.write("displayAllSortedByName");
		return result;
	}

	public String displayAllSortedByNumberOfCustomers() {
		String result = "";
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		ArrayList<Marketplace> sortedList = new ArrayList<Marketplace>(listOfMarketplaces); 
		sortedList.sort(Comparator.comparing(Marketplace::getNumberOfCustomers).reversed());
		for (Marketplace m : sortedList) {
			result += m.toString() + '\n';
		}

		MyLogger.write("displayAllSortedByNumberOfCustomers");
		return result;
	}

	public String displayCustomers() {
		String result = "";
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		for (Marketplace m : listOfMarketplaces) {
			for (Customer customer : m.getCustomers()) {
				result += customer.getName() + '\n';
			}
		}

		MyLogger.write("displayCustomers");
		return result;
	}
	
	public String displayCustomersPerMarketplace() {
		String result = "";
		List<Marketplace> listOfMarketplaces = marketplaceRepository.getListOfMarketplaces();
		for (Marketplace m : listOfMarketplaces) {
			result += "------------------------------" + '\n';
			result += "Nume: " + m.getName() + '\n';
			for (Customer customer : m.getCustomers()) {
				result += customer.getName() + '\n';
			}
		}

		MyLogger.write("displayCustomersPerMarketplace");
		return result;
	}

	public List<String> toCSV() {
		return marketplaceRepository.toCSV();
	}
	
}
