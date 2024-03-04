package com.mini.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class None implements Strategy{
    public ArrayList<String> find(HashMap<String, HashSet<String>> indexMap, String query){
        String[] words = query.split(" ");
        HashSet<String> match = new HashSet<String>();
        HashSet<String> result = new HashSet<String>();
        for(String word:words){
            if(indexMap.containsKey(word.toLowerCase())){
                match.addAll(indexMap.get(word.toLowerCase()));
            }
        }
        Set<String> set = indexMap.keySet();
        for(String s:set){
            if(!query.toLowerCase().contains(s)){
                result.addAll(indexMap.get(s));
            }
        }

        result.removeAll(match);
        if(result.size() == 0) return new ArrayList<String>();
        else return new ArrayList<String>(result);
    }
}
