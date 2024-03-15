package com.mini.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Strategy {
    public ArrayList<String> find(HashMap<String, HashSet<String>> indexMap, String query);
}
