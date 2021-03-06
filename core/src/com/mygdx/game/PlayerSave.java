package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by mahmo266317 on 5/4/2015.
 */
public class PlayerSave {
    private volatile ArrayList<Restaurant> restaurants;
    private volatile ArrayList<Restaurant> potentialRestaurants;
    private ArrayList<Territory> territories;
    private ArrayList<Territory> potentialTerritories;
    int current;
    double totalMoney, totalPasta, pastaPerClick;
    boolean country, save, music;
    public PlayerSave()
    {
        save = true;
        restaurants = new ArrayList<Restaurant>();
        potentialRestaurants = new ArrayList<Restaurant>();
        territories = new ArrayList<Territory>();
        potentialTerritories = new ArrayList<Territory>();
        current = 0;
        totalMoney = 0;
        totalPasta = 0;
        pastaPerClick = 0.5;
        music = true;
    }

    public boolean init()
    {
        restaurants = new ArrayList<Restaurant>();
        return restaurants.add(new Restaurant());
    }

    public boolean reset()
    {
        restaurants = new ArrayList<Restaurant>();
        potentialRestaurants = new ArrayList<Restaurant>();
        territories = new ArrayList<Territory>();
        potentialTerritories = new ArrayList<Territory>();
        current = 0;
        totalMoney = 0;
        totalPasta = 0;
        restaurants = new ArrayList<Restaurant>();
        country = false;
        return restaurants.add(new Restaurant());
    }

    public ArrayList<Restaurant> getRestaurants()
    {
        return restaurants;
    }

    public ArrayList<Restaurant> getPotentialRestaurants()
    {
        return potentialRestaurants;
    }

    public ArrayList<Territory> getTerritories()
    {
        return territories;
    }

    public ArrayList<Territory> getPotentialTerritories()
    {
        return potentialTerritories;
    }

    public Restaurant getCurrentRestaurant()
    {
        return restaurants.get(current);
    }

    public Territory getCurrentTerritory()
    {
        return territories.get(current);
    }

    public void setCurrent(int current)
    {
        this.current = current;
    }

    public void setTotalMoney(double total)
    {
        this.totalMoney = total;
    }

    public double getTotalMoney()
    {
        return totalMoney;
    }

    public void setTotalPasta(double total)
    {
        this.totalPasta = total;
    }

    public double getTotalPasta()
    {
        return totalPasta;
    }

    public double pastaPerSecond()
    {
        double d = 0;
        if(!country) {
            for (Restaurant r : restaurants) {
                d += r.getIncomePerSecond();
            }
        }
        else {
            for (Territory t : territories) {
                d += t.getIncomePerSecond();
            }
        }

        return d;
    }

    public double moneyPerSecond()
    {
        double d = 0;
        for(Restaurant r : restaurants)
        {
            d += r.getMoneyPerSecond();
        }
        for(Territory t : territories)
        {
            d += t.getMoneyPerSecond();
        }

        return d;
    }

    public void setPPC(double pastaPerClick)
    {
        this.pastaPerClick = pastaPerClick;
    }

    public double getPPC()
    {
        return pastaPerClick;
    }
}
