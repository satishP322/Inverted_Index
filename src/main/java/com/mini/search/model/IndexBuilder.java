package com.mini.search.model;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class IndexBuilder {
    public HashMap<String, HashSet<String>> buildIndex(HashMap<String, ArrayList<String>> map){
        HashMap<String, HashSet<String>> indexMap = new HashMap<String, HashSet<String>>();
        Set<String> files = map.keySet();
        for(String file:files) {
            ArrayList<String> lines = map.get(file);
            for (String line : lines) {
                String words[] = line.split(" ");
                for(String word:words){
                    if(!indexMap.containsKey(word.toLowerCase())){
                        HashSet<String> hSet = new HashSet<String>();
                        hSet.add(file);
                        indexMap.put(word.toLowerCase(),hSet);
                    }
                    else{
                        indexMap.get(word.toLowerCase()).add(file);
                    }
                }
            }
        }

        return indexMap;
    }
}
