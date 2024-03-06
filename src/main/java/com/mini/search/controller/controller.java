package com.mini.search.controller;


import com.mini.search.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;


@Controller
public class controller {

    @Autowired
    IndexBuilder ib;

    @GetMapping(path = "/search", produces = "text/html")
    public String search(Model model){
        model.addAttribute("value", "");
        model.addAttribute("results", new ArrayList<>());
        return "search";
    }

    @GetMapping(path="/files", produces="text/html")
    public String exploreFile(@RequestParam String file, Model model) throws Exception{
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            list.add(str);
        }
        sc.close();
        model.addAttribute("lines", list);
        return "fileData";
    }

    @PostMapping(path = "/search", produces="text/html")
    public String result(Query query, Model model) throws Exception {
        //opens a file that has list of all files on your local machine.
        FileInputStream fis = new FileInputStream("/home/rockzzz/Music/allFilePaths.txt");
        Scanner sc = new Scanner(fis);

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        while(sc.hasNextLine()){
            String string = sc.nextLine();
            FileInputStream fisTemp = new FileInputStream(string);
            Scanner scTemp = new Scanner(fisTemp);
            ArrayList<String> lines = new ArrayList<String>();
            while(scTemp.hasNextLine()){
                lines.add(scTemp.nextLine());
            }
            scTemp.close();
            map.put(string, lines);
        }
        sc.close();


       /*  // printing all the lines
        Set s = map.keySet();
        for(Object o:s){
            for(String str:map.get((String)o)){
                System.out.println(str);
            }
        }*/

        HashMap<String, HashSet<String>> indexMap = ib.buildIndex(map);

        Finder finder = new Finder();

        ArrayList<String> result = new ArrayList<String>();
        if(query.strategy.equalsIgnoreCase("ALL")){
            finder.setStrategy(new All());
            result = finder.find(indexMap, query.search);
        }

        if(query.strategy.equalsIgnoreCase("ANY")){
            finder.setStrategy(new Any());
            result = finder.find(indexMap, query.search);
        }

        if(query.strategy.equalsIgnoreCase("NONE")){
            finder.setStrategy(new None());
            result = finder.find(indexMap, query.search);
        }

        List<String> list = new ArrayList<String>();
        list.addAll(result);
        model.addAttribute("results",list);
        model.addAttribute("value", query.search);

        return "search";
    }
}