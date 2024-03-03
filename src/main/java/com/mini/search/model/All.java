package com.mini.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class All implements Strategy{
    public ArrayList<String> find(HashMap<String, HashSet<String>> indexMap, String query){
        String words[] = query.split(" ");
        ArrayList<String> all = new ArrayList<String>();
        int flag = 0;
        for(String word:words){
            if(indexMap.containsKey(word.toLowerCase())){
                if(flag == 0){
                    flag = 1;
                    all.addAll(indexMap.get(word.toLowerCase()));
                }
                else{
                    all.retainAll(indexMap.get(word.toLowerCase()));
                }
            }
            else{
                return new ArrayList<String>();
            }
        }

        return all;
    }
}
