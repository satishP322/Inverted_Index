package com.mini.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Any implements Strategy{
    public ArrayList<String> find(HashMap<String, HashSet<String>> indexMap, String query){
        String words[] = query.split(" ");
        HashSet<String> hSet = new HashSet<String>();
        for(String word:words){
            if(indexMap.containsKey(word.toLowerCase())){
                hSet.addAll(indexMap.get(word.toLowerCase()));
            }
        }

        if(hSet.size() == 0) return new ArrayList<String>();
        return new ArrayList<String>(hSet);
    }
}
