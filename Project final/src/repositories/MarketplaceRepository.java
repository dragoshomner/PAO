package repositories;

import models.Marketplace;

import java.util.ArrayList;

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
}
