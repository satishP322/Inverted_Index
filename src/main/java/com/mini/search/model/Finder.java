package com.mini.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Finder {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<String> find(HashMap<String, HashSet<String>> indexMap, String query){
        return strategy.find(indexMap, query);
    }
}
