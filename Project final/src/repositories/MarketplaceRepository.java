package repositories;

import models.Customer;
import models.Marketplace;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceRepository {

    private ArrayList<Marketplace> listOfMarketplaces;

    public MarketplaceRepository() {
        listOfMarketplaces = new ArrayList<Marketplace>();
    }

    public void add(Marketplace marketplace) {
        listOfMarketplaces.add(marketplace);
    }

    public ArrayList<Marketplace> getListOfMarketplaces() {
        return listOfMarketplaces;
    }

    public void setListOfMarketplaces(ArrayList<Marketplace> listOfMarketplaces) {
        this.listOfMarketplaces = listOfMarketplaces;
    }

    public Marketplace findByCode(String code) {
        return listOfMarketplaces.stream()
                .filter(marketplace -> marketplace.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public List<String> toCSV() {
        List<String> output = new ArrayList<>();
        for (Marketplace marketplace : listOfMarketplaces) {
            output.add(marketplace.toCSV());
        }
        return output;
    }
}
